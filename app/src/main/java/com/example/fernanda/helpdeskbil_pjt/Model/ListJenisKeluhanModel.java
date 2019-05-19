package com.example.fernanda.helpdeskbil_pjt.Model;

public class ListJenisKeluhanModel {
    int id_jenis_keluhan;
    String nama_jenis_keluhan;

    public  ListJenisKeluhanModel(int id, String nama_jk){
        this.id_jenis_keluhan=id;
        this.nama_jenis_keluhan=nama_jk;
    }

    public int getId_jenis_keluhan() {
        return id_jenis_keluhan;
    }

    public void setId_jenis_keluhan(int id_jenis_keluhan) {
        this.id_jenis_keluhan = id_jenis_keluhan;
    }

    public String getNama_jenis_keluhan() {
        return nama_jenis_keluhan;
    }

    public void setNama_jenis_keluhan(String nama_jenis_keluhan) {
        this.nama_jenis_keluhan = nama_jenis_keluhan;
    }

    @Override
    public String toString() {
        return getNama_jenis_keluhan();
    }

}
