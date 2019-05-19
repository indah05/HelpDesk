package com.example.fernanda.helpdeskbil_pjt.ListInventaris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fernanda.helpdeskbil_pjt.Adapter.InventarisAdapter;
import com.example.fernanda.helpdeskbil_pjt.Model.KeluhanModel;
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

public class InventarisActivity extends AppCompatActivity {

//    private Context ctx;
    public static final String URL = "http://36.66.205.251/report1/";
    private List<KeluhanModel> results = new ArrayList<>();
    private InventarisAdapter viewAdapter;
    RecyclerView rvListInven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventaris);

        rvListInven = findViewById(R.id.rvListInventaris);

        viewAdapter = new InventarisAdapter(this, results);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvListInven.setLayoutManager(mLayoutManager);
        rvListInven.setItemAnimator(new DefaultItemAnimator());
        rvListInven.setAdapter(viewAdapter);

        loadDataInventaris();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadDataInventaris(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.view_inventaris();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                if(value.equals("1")){
                    results = response.body().getResult();
                    if(results != null){
                        viewAdapter = new InventarisAdapter(InventarisActivity.this, results);
                        rvListInven.setAdapter(viewAdapter);
                        System.out.print("+++RESULT+++"+results);
                    } else{
                        Toast.makeText(InventarisActivity.this, "Terjadi Kesalahan!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(InventarisActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
