package com.example.tanaman;

public class tanaman {
    private String nama;
    private String harga;
    private String gambar;
    private String keterangan;
    private String info;
    private String judul;
    private String history;
    private String cara;

    public tanaman(String datanama, String dataharga, String datagambar, String dataketerangan, String datainfo, String datajudul, String datahistory, String datacara){
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
        keterangan = dataketerangan;
        info = datainfo;
        judul = datajudul;
        history = datahistory;
        cara = datacara;
}

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getKeterangan() { return keterangan; }

    public String getInfo() {
        return info;
    }

    public String getJudul() {
        return judul;
    }

    public String getHistory() {
        return history;
    }

    public String getCara() {
        return cara;
    }
}
