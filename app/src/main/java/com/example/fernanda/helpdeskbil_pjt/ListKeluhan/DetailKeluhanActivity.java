package com.example.fernanda.helpdeskbil_pjt.ListKeluhan;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fernanda.helpdeskbil_pjt.R;

public class DetailKeluhanActivity extends AppCompatActivity {

    public static String EXTRA_ID = "EXTRA_ID";
    public static String EXTRA_STATUS = "EXTRA_STATUS";
    public static String EXTRA_JENIS_KELUHAN = "EXTRA_JENIS_KELUHAN";
    public static String EXTRA_KELUHAN = "EXTRA_KELUHAN";
    public static String EXTRA_TGL_KELUHAN = "EXTRA_TGL_KELUHAN";
    public static String EXTRA_UNIT = "EXTRA_UNIT";
    public static String EXTRA_PELAKSANA = "EXTRA_PELAKSANA";
    public static String EXTRA_TGL_SELESAI = "EXTRA_TGL_SELESAI";
    public static String EXTRA_NAMA_PENGELUH = "EXTRA_NAMA_PENGELUH";

    String status, jenis_keluhan, text_keluhan, tgl_keluhan, nama_unit, tgl_selesai, nama_pengeluh;
    int id, id_pelaksana;
    TextView tv_id, tv_nama_pengeluh, tv_unit, tv_tgl_keluhan, tv_jenis_keluhan, tv_keluhan, tv_txt_status, tv_nama_pelaksana, tv_tgl_selesai;
    ImageView bg_status;

    CollapsingToolbarLayout collapsingToolbar;
    int mutedColor = R.attr.colorPrimary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_keluhan);

        tv_id = findViewById(R.id.detail_id);
        tv_nama_pengeluh = findViewById(R.id.detail_nama_pengeluh);
        tv_unit = findViewById(R.id.detail_unit);
        tv_tgl_keluhan = findViewById(R.id.detail_tgl_keluhan);
        tv_jenis_keluhan = findViewById(R.id.detail_jenis_keluhan);
        tv_keluhan = findViewById(R.id.detail_keluhan);
        tv_txt_status = findViewById(R.id.detail_status_txt);
        tv_nama_pelaksana = findViewById(R.id.detail_nama_pelaksana);
        tv_tgl_selesai = findViewById(R.id.detail_tgl_selesai);
        bg_status = findViewById(R.id.detail_status_bg);

        if (getIntent().getExtras() != null) {
            id = getIntent().getIntExtra(EXTRA_ID,0);
            String sid = String.valueOf(id);
            status = getIntent().getStringExtra(EXTRA_STATUS);
            jenis_keluhan = getIntent().getStringExtra(EXTRA_JENIS_KELUHAN);
            text_keluhan = getIntent().getStringExtra(EXTRA_KELUHAN);
            tgl_keluhan = getIntent().getStringExtra(EXTRA_TGL_KELUHAN);
            nama_unit = getIntent().getStringExtra(EXTRA_UNIT);
            id_pelaksana = getIntent().getIntExtra(EXTRA_PELAKSANA, 0);
            String sid_pelaksana = String.valueOf(id_pelaksana);
            tgl_selesai = getIntent().getStringExtra(EXTRA_TGL_SELESAI);
            nama_pengeluh = getIntent().getStringExtra(EXTRA_NAMA_PENGELUH);

            System.out.print("++++Pelaksana+++++"+id_pelaksana);
            System.out.print("++++NAMA+++++"+nama_pengeluh);

            tv_id.setText(sid);
            tv_nama_pengeluh.setText(nama_pengeluh);
            tv_unit.setText(nama_unit);
            tv_tgl_keluhan.setText(tgl_keluhan);
            tv_jenis_keluhan.setText(jenis_keluhan);
            tv_keluhan.setText(text_keluhan);
            tv_txt_status.setText(status);
            tv_nama_pelaksana.setText(sid_pelaksana);
            tv_tgl_selesai.setText(tgl_selesai);
            if (status.equals("PROGRES")){
                bg_status.setImageResource(R.drawable.status_progress);
            }else if(status.equals("SELESAI")){
                bg_status.setImageResource(R.drawable.status_selesai);
            } else {
                tv_txt_status.setText("tidak ada status");
            }
            if(id_pelaksana == 0){
                tv_nama_pelaksana.setText("Belum ditangani");
            }

            if(TextUtils.isEmpty(tgl_selesai)){
                tv_tgl_selesai.setText("Belum selesai ditangani");
            }
        }
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // pengaturan dan inisialisasi collapsing toolbar
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(jenis_keluhan);
        collapsingToolbar.setExpandedTitleColor(Color.parseColor("#303F9F"));
    }
}
