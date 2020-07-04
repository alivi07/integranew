package com.example.myapplication.api;

import android.content.Context;

import com.example.myapplication.api.config.RetrofitBuilder;
import com.example.myapplication.api.interfaces.LoginInterface;

import retrofit2.Callback;

public class LoginService {
    private LoginInterface loginInterface;

    public LoginService(Context context) {
        loginInterface = RetrofitBuilder.builder(context)
                .create(LoginInterface.class);
    }

    public void doLogin(String email, String password, Callback callback) {
        loginInterface.login(email, password).enqueue(callback);
    }
}
