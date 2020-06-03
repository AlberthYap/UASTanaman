package com.example.tanaman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements tanamanadapter.OnItemClickListener {
    public static final String EXTRA_NAMA = "namamenu";
    public static final String EXTRA_HARGA = "hargamenu";
    public static final String EXTRA_GAMBAR = "gambarmenu";
    public static final String EXTRA_INFO = "infomenu";
    public static final String EXTRA_JUDUL = "judulmenu";
    public static final String EXTRA_HISTORY = "historymenu";
    public static final String EXTRA_CARA = "caramenu";


    private tanamanadapter tanamanAdapter;
    private RecyclerView recyclerView;
    private ArrayList<tanaman>  tanamans;
    int jumdata;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        tanamans = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        parseJSON();

    }

    private void parseJSON() {
        String url = "https://uasalberth.000webhostapp.com/koneksi.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jumdata = response.length();
                        try {
                            for (int i = 0; i < jumdata; i++) {
                                JSONObject data = response.getJSONObject(i);
                                String gambarmenu = data.getString("gambar");
                                String namamenu = data.getString("nama");
                                String hargamenu = data.getString("harga");
                                String keteranganmenu = data.getString("keterangan");
                                String infomenu = data.getString("info");
                                String judulmenu = data.getString("judul");
                                String historymenu = data.getString("history");
                                String caramenu = data.getString("cara");
                                tanamans.add(new tanaman(namamenu, hargamenu, gambarmenu, keteranganmenu, infomenu, judulmenu, historymenu, caramenu));
                            }
                            tanamanAdapter = new tanamanadapter(MainActivity.this, tanamans);
                            recyclerView.setAdapter(tanamanAdapter);
                            tanamanAdapter.setOnItemClickListener(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
    });
        requestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent pindahdata = new Intent(MainActivity.this,detailactivity.class);
        tanaman clicked = tanamans.get(position);

        pindahdata.putExtra(EXTRA_NAMA, clicked.getNama());
        pindahdata.putExtra(EXTRA_GAMBAR, clicked.getGambar());
        pindahdata.putExtra(EXTRA_HARGA, clicked.getHarga());
        pindahdata.putExtra(EXTRA_INFO, clicked.getInfo());
        pindahdata.putExtra(EXTRA_JUDUL, clicked.getJudul());
        pindahdata.putExtra(EXTRA_HISTORY, clicked.getHistory());
        pindahdata.putExtra(EXTRA_CARA, clicked.getCara());

        startActivity(pindahdata);

    }
}
