package com.mobilemocap.ahmadriza.apik.Model;

/**
 * Created by Ahmad Riza on 20/06/2017.
 */

public class Makanan {
    private int id;
    private String nama;
    private int jenis;
    private double kalori;

    public Makanan(int id, String nama, int jenis, double kalori) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.kalori = kalori;
    }

    public String getNama() {
        return nama;
    }

    public double getKalori() {
        return kalori;
    }

    public int getId() {
        return id;
    }

    public int getJenis() {
        return jenis;
    }
}
