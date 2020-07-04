package com.example.myapplication.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LaporanResponse{

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	@SerializedName("email")
	private String email;

	@SerializedName("absen")
	private List<AbsenItem> absen;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAbsen(List<AbsenItem> absen){
		this.absen = absen;
	}

	public List<AbsenItem> getAbsen(){
		return absen;
	}

	@Override
 	public String toString(){
		return 
			"LaporanResponse{" + 
			"error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			",email = '" + email + '\'' + 
			",absen = '" + absen + '\'' + 
			"}";
		}
}