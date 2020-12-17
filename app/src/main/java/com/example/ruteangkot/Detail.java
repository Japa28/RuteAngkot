package com.example.ruteangkot;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.detail);

        TextView mTrayek = findViewById(R.id.ruteTrayek);
        TextView mLintasan = findViewById(R.id.ruteLintasan);
        ImageView mRuteImage = findViewById(R.id.ruteImage);

        mTrayek.setText("Trayek : " + getIntent().getStringExtra("trayek"));
        mLintasan.setText("Lintasan : " + getIntent().getStringExtra( "lintasan"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("gambar_url")).error(R.mipmap.ic_launcher).override(512, 512).into(mRuteImage);
    }
}
