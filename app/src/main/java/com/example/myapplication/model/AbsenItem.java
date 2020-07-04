package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class AbsenItem{

	@SerializedName("ketPulang")
	private String ketPulang;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("ketMasuk")
	private String ketMasuk;

	@SerializedName("jam datang")
	private String jamDatang;

	@SerializedName("jam pulang")
	private String jamPulang;

	public String getKetPulang(){
		return ketPulang;
	}

	public String getTanggal(){
		return tanggal;
	}

	public String getKetMasuk(){
		return ketMasuk;
	}

	public String getJamDatang(){
		return jamDatang;
	}

	public String getJamPulang(){
		return jamPulang;
	}
}