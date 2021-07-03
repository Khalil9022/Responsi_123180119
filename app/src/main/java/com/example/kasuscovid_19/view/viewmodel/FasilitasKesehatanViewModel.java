package com.example.kasuscovid_19.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kasuscovid_19.model.fasilitas_kesehatan.FasilitasKesehatanResponse;
import com.example.kasuscovid_19.model.fasilitas_kesehatan.FasilitasiKesehatanDataItem;
import com.example.kasuscovid_19.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FasilitasKesehatanViewModel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<FasilitasiKesehatanDataItem>> listFasilitas = new MutableLiveData<>();

    public void setFasilitasDiscover() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiFasilitasKesehatan().getFasilitasKesehatan().enqueue(new Callback<FasilitasKesehatanResponse>() {
            @Override
            public void onResponse(Call<FasilitasKesehatanResponse> call, Response<FasilitasKesehatanResponse> response) {
                FasilitasKesehatanResponse fasilitasDiscover = response.body();
                if(fasilitasDiscover != null && fasilitasDiscover.getData() != null){
                    ArrayList<FasilitasiKesehatanDataItem> fasilitasiKesehatanDataItems = fasilitasDiscover.getData();
                    listFasilitas.postValue(fasilitasiKesehatanDataItems);
                }
            }

            @Override
            public void onFailure(Call<FasilitasKesehatanResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<FasilitasiKesehatanDataItem>> getFasilitasDiscover(){
        return listFasilitas;
    }
}
