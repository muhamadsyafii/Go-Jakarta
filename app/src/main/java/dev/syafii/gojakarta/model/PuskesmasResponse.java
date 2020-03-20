package dev.syafii.gojakarta.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PuskesmasResponse{

	@SerializedName("data")
	private List<PuskesmasData> data;

	@SerializedName("count")
	private int count;

	@SerializedName("status")
	private String status;

	public void setData(List<PuskesmasData> data){
		this.data = data;
	}

	public List<PuskesmasData> getData(){
		return data;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}