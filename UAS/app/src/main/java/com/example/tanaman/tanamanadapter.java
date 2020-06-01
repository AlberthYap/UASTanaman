package com.example.tanaman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class tanamanadapter extends RecyclerView.Adapter <tanamanadapter.tanamanviewholder> {
    private Context context;
    private ArrayList<tanaman> tanamans;

    public  tanamanadapter(Context tcontext, ArrayList<tanaman> tanamanss){
        context = tcontext;
        tanamans = tanamanss;


    }

    @NonNull
    @Override
    public tanamanviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_tanaman, parent,false);

        return new tanamanviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull tanamanviewholder holder, int position) {
            tanaman tanamanbaru = tanamans.get(position);
            String gambarbaru = tanamanbaru.getGambar();
            String harga = tanamanbaru.getHarga();
            String nama = tanamanbaru.getNama();

            holder.tvnamadata.setText(nama);
            holder.tvhargadata.setText(harga);
        Glide
                .with(context)
                .load(gambarbaru)
                .centerCrop()
                .into(holder.imdata);

    }

    @Override
    public int getItemCount() {
        return tanamans.size();
    }


    public class tanamanviewholder extends RecyclerView.ViewHolder {
        public ImageView imdata;
        public TextView tvhargadata;
        public TextView tvnamadata;

        public tanamanviewholder(@NonNull View itemView) {
            super(itemView);
            imdata = itemView.findViewById(R.id.img_tanaman);
            tvhargadata = itemView.findViewById(R.id.tv_harga);
            tvnamadata = itemView.findViewById(R.id.tv_nama);


        }
    }

}
