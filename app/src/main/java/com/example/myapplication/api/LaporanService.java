package com.example.myapplication.api;

import com.example.myapplication.api.config.Config;
import com.example.myapplication.api.interfaces.LaporanInterface;
import com.example.myapplication.model.LaporanResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaporanService {
    private Retrofit retrofit;
    public  LaporanInterface getAPILaporan(){
        if (retrofit==null)
        {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit.create(LaporanInterface.class);

    }
}
