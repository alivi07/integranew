package com.example.myapplication.api.interfaces;

import com.example.myapplication.api.config.Config;
import com.example.myapplication.model.LaporanResponse;
import com.example.myapplication.model.ScanResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LaporanInterface {
    @FormUrlEncoded
    @POST(Config.API_LAPORAN)
    Call<LaporanResponse> getAllLaporan(
            @Field("email") String email,
            @Field("tanggal") String tanggal,
            @Field("spinner") String spinner
    );

//    @GET(Config.API_LAPORAN + "/")
//    Call<LaporanResponse> getLaporanapi(
//            @Query("email") String email
//    );
}
