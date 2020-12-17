package com.example.ruteangkot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ruteangkot.adapter.RuteAdapter;
import com.example.ruteangkot.model.ModelRute;
import com.example.ruteangkot.model.RuteAngkotItem;
import com.example.ruteangkot.res.ApiConfiguration;
import com.example.ruteangkot.res.ApiSvc;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<RuteAngkotItem> ruteItems;
    private RuteAdapter ruteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ruteItems = new ArrayList<>();
        getData();

    }

    private void getData() {
        ApiSvc apiSvc = ApiConfiguration.getApiSvc();
        apiSvc.getData().enqueue(new Callback<ModelRute>() {
            @Override
            public void onResponse(Call<ModelRute> call, Response<ModelRute> response) {
                if (response.isSuccessful()) {
                    ruteItems = response.body().getRuteAngkot();
                    ruteAdapter = new RuteAdapter(ruteItems, getApplicationContext());
                    recyclerView.setAdapter(ruteAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<ModelRute> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv_rute);
    }
}