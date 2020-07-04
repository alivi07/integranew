package com.example.myapplication.api.interfaces;

import com.example.myapplication.api.config.Config;
import com.example.myapplication.model.ScanResponse;
import com.example.myapplication.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ScannerInterface {
    @FormUrlEncoded
    @POST(Config.API_SCANNER)
    Call<ScanResponse> scan(
            @Field("email") String email,
            @Field("tanggal") String tanggal);
}
