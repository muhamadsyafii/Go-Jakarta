package dev.syafii.gojakarta.model;

import com.google.gson.annotations.SerializedName;

public class PuskesmasLocation {

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("longitude")
	private double longitude;

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}
}