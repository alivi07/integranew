package com.example.myapplication.api;

import android.content.Context;

import com.example.myapplication.api.config.RetrofitBuilder;
import com.example.myapplication.api.interfaces.ScannerInterface;

import retrofit2.Callback;

public class ScanService {
    private ScannerInterface scannerInterface;

    public ScanService(Context context) {
        scannerInterface = RetrofitBuilder.builder(context)
                .create(ScannerInterface.class);
    }

    public void doScanner(String email, String tanggal, Callback callback) {
        scannerInterface.scan(email, tanggal).enqueue(callback);
    }
}
