package com.example.kasuscovid_19.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kasuscovid_19.R;
import com.example.kasuscovid_19.model.fasilitas_kesehatan.FasilitasiKesehatanDataItem;

import java.util.ArrayList;

public class FasilitasKesehatanAdapter extends RecyclerView.Adapter<FasilitasKesehatanAdapter.ViewHolder> {
    private ArrayList<FasilitasiKesehatanDataItem> fasilitasiKesehatanDataItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<FasilitasiKesehatanDataItem> items){
        fasilitasiKesehatanDataItems.clear();
        fasilitasiKesehatanDataItems.addAll(items);
        notifyDataSetChanged();
    }

    public FasilitasKesehatanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FasilitasKesehatanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fasilitaskesehatan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FasilitasKesehatanAdapter.ViewHolder holder, int position) {
        holder.tv_namaRS.setText(fasilitasiKesehatanDataItems.get(position).getNama());
        holder.tv_alamatRS.setText(fasilitasiKesehatanDataItems.get(position).getAlamat());
        holder.btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194?q=restaurants"));
//                intent.setPackage("com.google.android.apps.maps");
//                context.startActivities(new Intent[]{intent});
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+ fasilitasiKesehatanDataItems.get(position).getAlamat()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fasilitasiKesehatanDataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_namaRS,tv_alamatRS;
        Button btn_map;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_namaRS = itemView.findViewById(R.id.itemfasilitaskesehatan_tv_namaRS);
            tv_alamatRS = itemView.findViewById(R.id.itemfasilitaskesehatan_tv_alamatRS);
            btn_map = itemView.findViewById(R.id.itemfasilitaskesehatan_btn_map);
        }
    }
}
