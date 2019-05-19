package com.example.fernanda.helpdeskbil_pjt.Model;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class KeluhanModel {

    int IDKELUHAN;
    String NAMA;
    String UNIT;
    String TGL_KELUHAN;
    String KELUHAN;
    String STATUS;
    int IDPEGAWAI;
    String TGL_SELESAI;
    String JENIS_KELUHAN;
    int IDUNIT;

    String JENIS_KOMPUTER;
    String SPESIFIKASI;
    String TAHUN_PEMBELIAN;
    String KONDISI;

    public String getJENIS_KOMPUTER() {
        return JENIS_KOMPUTER;
    }

    public String getSPESIFIKASI() {
        return SPESIFIKASI;
    }

    public String getTAHUN_PEMBELIAN() {
        return TAHUN_PEMBELIAN;
    }

    public String getKONDISI() {
        return KONDISI;
    }

    int IDJENIS_KELUHAN;

    public int getIDJENIS_KELUHAN() {
        return IDJENIS_KELUHAN;
    }

    public int getIDUNIT() {
        return IDUNIT;
    }

    public int getIDKELUHAN() {
        return IDKELUHAN;
    }

    public String getNAMA() {
        return NAMA;
    }

    public String getUNIT() {
        return UNIT;
    }

    public String getTGL_KELUHAN() {
        return TGL_KELUHAN;
    }

    public String getKELUHAN() {
        return KELUHAN;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public int getIDPEGAWAI() {
        return IDPEGAWAI;
    }

    public String getTGL_SELESAI() {
        return TGL_SELESAI;
    }

    public String getJENIS_KELUHAN() {
        return JENIS_KELUHAN;
    }

}
