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

public class tanamanadapter extends RecyclerView.Adapter<tanamanadapter.tanamanviewholder> {
private Context context;
private ArrayList <tanaman> tanamans;
private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

        public tanamanadapter(Context tcontext, ArrayList<tanaman> ttanaman)
        {
            this.context = tcontext;
            tanamans =ttanaman;

        }

    @NonNull
    @Override
    public tanamanviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_tanaman,parent,false);

            return new tanamanviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull tanamanviewholder holder, int position) {
            tanaman tanamanbaru = tanamans.get(position);
            String gambarbaru = tanamanbaru.getGambar();
            String harga = tanamanbaru.getHarga();
            String nama = tanamanbaru.getNama();
            String keterangan = tanamanbaru.getKeterangan();


            holder.tvnamadata.setText(nama);
            holder.tvhargadata.setText(harga);
            holder.tvketerangandata.setText(keterangan);


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
        public TextView tvketerangandata;
        public tanamanviewholder(@NonNull View itemView) {
            super(itemView);

            imdata = itemView.findViewById(R.id.img_tanaman);
            tvhargadata = itemView.findViewById(R.id.tv_harga);
            tvnamadata = itemView.findViewById(R.id.tv_nama);
            tvketerangandata = itemView.findViewById(R.id.tv_keterangan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

}
