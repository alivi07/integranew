package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @SerializedName("error")
    private boolean error;
    @SerializedName("message")
    private String message;

    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;
    @SerializedName("instansi")
    private String instansi;

    public BaseResponse() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    @Override
    public String toString() {
        return
                "BaseResponse{" +
                        "error = '" + error + '\'' +
                        ",message = '" + message + '\'' +
                        ",nama = '" + nama + '\'' +
                        ",email = '" + email + '\'' +
                        ",instansi = '" + instansi + '\'' +
                        "}";
    }
}
