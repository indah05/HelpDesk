package com.example.fernanda.helpdeskbil_pjt.ListKeluhan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fernanda.helpdeskbil_pjt.Adapter.ListKeluhanAdapter;
import com.example.fernanda.helpdeskbil_pjt.Connection.RegisterAPI;
import com.example.fernanda.helpdeskbil_pjt.Model.KeluhanModel;
import com.example.fernanda.helpdeskbil_pjt.Model.Value;
import com.example.fernanda.helpdeskbil_pjt.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentListKeluhan extends Fragment{
    public static final String URL = "http://36.66.205.251/report1/";
    private List<KeluhanModel> results = new ArrayList<>();
    private ListKeluhanAdapter viewAdapter;
    RecyclerView rvListKeluhan;
//    ArrayList<KeluhanModel> results;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_keluhan, container, false);

        rvListKeluhan = rootView.findViewById(R.id.rvListKeluhan);

        viewAdapter = new ListKeluhanAdapter(getActivity(), results);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        rvListKeluhan.setLayoutManager(mLayoutManager);
        rvListKeluhan.setItemAnimator(new DefaultItemAnimator());
        rvListKeluhan.setAdapter(viewAdapter);
        loadData();

        return rootView;
    }

    private void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.view();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                if(value.equals("1")){
                    results = response.body().getResult();
                    viewAdapter = new ListKeluhanAdapter(getActivity(), results);
                    rvListKeluhan.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }
}
