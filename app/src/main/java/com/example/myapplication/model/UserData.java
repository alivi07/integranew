package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;
    @SerializedName("instansi")
    private String instansi;

    public UserData() {
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
                "Data{" +
                        "nama = '" + nama + '\'' +
                        ",email = '" + email + '\'' +
                        ",instansi = '" + instansi + '\'' +
                        "}";
    }
}
