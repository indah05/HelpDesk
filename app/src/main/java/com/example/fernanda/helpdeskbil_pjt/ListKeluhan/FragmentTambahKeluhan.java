package com.example.fernanda.helpdeskbil_pjt.ListKeluhan;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fernanda.helpdeskbil_pjt.Model.KeluhanModel;
import com.example.fernanda.helpdeskbil_pjt.Model.ListJenisKeluhanModel;
import com.example.fernanda.helpdeskbil_pjt.Model.ListUnitModel;
import com.example.fernanda.helpdeskbil_pjt.Connection.RegisterAPI;
import com.example.fernanda.helpdeskbil_pjt.Model.Value;
import com.example.fernanda.helpdeskbil_pjt.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentTambahKeluhan extends Fragment {
    public static final String URL = "http://36.66.205.251/report1/";
    EditText et_nama_pengeluh, et_keluhan;
    Spinner sp_unit, sp_jenis_keluhan;
    Button btn_save, btn_cancel;
    ArrayList<ListUnitModel> models_unit;
    ArrayList<ListJenisKeluhanModel> models_jenis_keluhan;
    int id_unit;
    String nama_unit;
    int id_jenis_keluhan;
    String nama_jenis_keluhan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tambah_keluhan, container, false);
        et_nama_pengeluh = rootView.findViewById(R.id.et_nama_pengeluh);
        et_keluhan = rootView.findViewById(R.id.et_keluhan);
        btn_save = rootView.findViewById(R.id.btn_save_keluhan);
        btn_cancel = rootView.findViewById(R.id.btn_cancel_keluhan);
        sp_jenis_keluhan = rootView.findViewById(R.id.sp_jenis_keluhan);
        sp_unit = rootView.findViewById(R.id.sp_unit);

        showListUnit();
        showListJenisKeluhan();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftar();
            }
        });

        sp_unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                id_unit = models_unit.get(i).getId();
                nama_unit = models_unit.get(i).getUnit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp_jenis_keluhan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                id_jenis_keluhan = models_jenis_keluhan.get(i).getId_jenis_keluhan();
                nama_jenis_keluhan = models_jenis_keluhan.get(i).getNama_jenis_keluhan();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return rootView;
    }

    public void showListUnit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.listUNIT();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
//                System.out.println("++++++++++VALUE+++++++++"+value);
                if(value.equals("1")){
                    models_unit = new ArrayList<>();
                    List<KeluhanModel> listunit = response.body().getResult();
//                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < listunit.size(); i++){
                        int id= listunit.get(i).getIDUNIT();
                        String unit = listunit.get(i).getUNIT();
                        models_unit.add(new ListUnitModel(id, unit));
                    }
                    ArrayAdapter<ColorSpace.Model> arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, models_unit);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_unit.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }

    public void showListJenisKeluhan(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.listJenisKeluhan();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                if(value.equals("1")){
                    models_jenis_keluhan = new ArrayList<>();
                    List<KeluhanModel> list_jenis_keluhan = response.body().getResult();
                    for (int i = 0; i < list_jenis_keluhan.size(); i++){
                        int id_jk= list_jenis_keluhan.get(i).getIDJENIS_KELUHAN();
                        String nama_jk = list_jenis_keluhan.get(i).getJENIS_KELUHAN();
                        models_jenis_keluhan.add(new ListJenisKeluhanModel(id_jk, nama_jk));
                    }
                    ArrayAdapter<ColorSpace.Model> arrayAdapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, models_jenis_keluhan);
                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_jenis_keluhan.setAdapter(arrayAdapter2);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }

    public void daftar(){
        final String nama_pengeluh = et_nama_pengeluh.getText().toString();
        String keluhan = et_keluhan.getText().toString();
        String status = "PROGRES";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.daftar(nama_pengeluh, id_unit, keluhan, id_jenis_keluhan, status);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                if (value.equals("1")) {
                    et_nama_pengeluh.setText("");
                    et_keluhan.setText("");
                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(getActivity(), "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
