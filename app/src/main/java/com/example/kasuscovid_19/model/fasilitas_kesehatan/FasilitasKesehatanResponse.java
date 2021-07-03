package com.example.kasuscovid_19.model.fasilitas_kesehatan;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FasilitasKesehatanResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<FasilitasiKesehatanDataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<FasilitasiKesehatanDataItem> data){
		this.data = data;
	}

	public ArrayList<FasilitasiKesehatanDataItem> getData(){
		return data;
	}
}