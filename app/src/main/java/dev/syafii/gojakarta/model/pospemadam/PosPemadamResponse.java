package dev.syafii.gojakarta.model.pospemadam;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PosPemadamResponse{

	@SerializedName("data")
	private List<PosPemadamData> data;

	@SerializedName("count")
	private int count;

	@SerializedName("status")
	private String status;

	public void setData(List<PosPemadamData> data){
		this.data = data;
	}

	public List<PosPemadamData> getData(){
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