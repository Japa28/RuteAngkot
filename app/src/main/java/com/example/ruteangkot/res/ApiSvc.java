package com.example.ruteangkot.res;

import com.example.ruteangkot.model.ModelRute;
import com.example.ruteangkot.model.RuteAngkotItem;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSvc {
    @GET("purwakarta/ruteangkot")
    Call<ModelRute> getData();

}
