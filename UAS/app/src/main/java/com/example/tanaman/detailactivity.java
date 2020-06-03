package com.example.tanaman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.tanaman.MainActivity.EXTRA_CARA;
import static com.example.tanaman.MainActivity.EXTRA_GAMBAR;
import static com.example.tanaman.MainActivity.EXTRA_HARGA;
import static com.example.tanaman.MainActivity.EXTRA_HISTORY;
import static com.example.tanaman.MainActivity.EXTRA_INFO;
import static com.example.tanaman.MainActivity.EXTRA_JUDUL;
import static com.example.tanaman.MainActivity.EXTRA_NAMA;

public class detailactivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailactivity);

        Intent intent = getIntent();
        String nama = intent.getStringExtra(EXTRA_NAMA);
        String harga = intent.getStringExtra(EXTRA_HARGA);
        String info = intent.getStringExtra(EXTRA_INFO);
        String judul = intent.getStringExtra(EXTRA_JUDUL);
        String history = intent.getStringExtra(EXTRA_HISTORY);
        String cara = intent.getStringExtra(EXTRA_CARA);
        String gambar = intent.getStringExtra(EXTRA_GAMBAR);

       TextView simpannama = findViewById(R.id.tvnama);
       TextView simpanharga = findViewById(R.id.tvharga);
       TextView simpaninfo = findViewById(R.id.tvinfo);
       TextView simpanjudul = findViewById(R.id.tvjudul);
       TextView simpanhistory = findViewById(R.id.tvhistory);
       TextView simpancara = findViewById(R.id.tvcara);
       ImageView simpangambar = findViewById(R.id.tgambar);

      Picasso.get().load(gambar).into(simpangambar);
       simpannama.setText(nama);
       simpanharga.setText(harga);
       simpaninfo.setText(info);
       simpanjudul.setText(judul);
       simpanhistory.setText(history);
       simpancara.setText(cara);




    }
}
