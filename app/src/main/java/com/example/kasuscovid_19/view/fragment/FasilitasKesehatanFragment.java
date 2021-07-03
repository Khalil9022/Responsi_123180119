package com.example.kasuscovid_19.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kasuscovid_19.R;
import com.example.kasuscovid_19.adapter.FasilitasKesehatanAdapter;
import com.example.kasuscovid_19.adapter.KasusHarianAdapter;
import com.example.kasuscovid_19.model.fasilitas_kesehatan.FasilitasiKesehatanDataItem;
import com.example.kasuscovid_19.model.kasus_harian.KasusHarianDataItem;
import com.example.kasuscovid_19.view.viewmodel.FasilitasKesehatanViewModel;
import com.example.kasuscovid_19.view.viewmodel.KasusHarianViewModel;

import java.util.ArrayList;

public class FasilitasKesehatanFragment extends Fragment  {

    private FasilitasKesehatanAdapter fasilitasKesehatanAdapter;
    private RecyclerView rvFasilitasKesehatan;
    private FasilitasKesehatanViewModel fasilitasKesehatanViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fasilitasKesehatanAdapter = new FasilitasKesehatanAdapter(getContext());
        fasilitasKesehatanAdapter.notifyDataSetChanged();

        rvFasilitasKesehatan = view.findViewById(R.id.fasilitaskesehatan_rv_main);
        rvFasilitasKesehatan.setLayoutManager(new LinearLayoutManager(getContext()));

        fasilitasKesehatanViewModel = new ViewModelProvider(this).get(FasilitasKesehatanViewModel.class);
        fasilitasKesehatanViewModel.setFasilitasDiscover();
        fasilitasKesehatanViewModel.getFasilitasDiscover().observe(this ,getFasilitasKesehatanDiscover);

        rvFasilitasKesehatan.setAdapter(fasilitasKesehatanAdapter);
    }

    private Observer<ArrayList<FasilitasiKesehatanDataItem>> getFasilitasKesehatanDiscover = new Observer<ArrayList<FasilitasiKesehatanDataItem>>() {
        @Override
        public void onChanged(ArrayList<FasilitasiKesehatanDataItem> fasilitasiKesehatanDataItems) {
            if(fasilitasiKesehatanDataItems != null){
                fasilitasKesehatanAdapter.setData(fasilitasiKesehatanDataItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fasilitas_kesehatan, container, false);
    }


}