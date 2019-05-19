package com.example.fernanda.helpdeskbil_pjt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fernanda.helpdeskbil_pjt.ListInventaris.InventarisActivity;
import com.example.fernanda.helpdeskbil_pjt.ListKeluhan.KeluhanActivity;

public class MainActivity extends AppCompatActivity {
    ImageView menu_keluhan, menu_inventaris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_keluhan = findViewById(R.id.keluhan);
        menu_inventaris = findViewById(R.id.inventaris);
        menu_keluhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keluhan = new Intent(MainActivity.this,KeluhanActivity.class);
                startActivity(keluhan);
            }
        });
        menu_inventaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inventaris = new Intent(MainActivity.this,InventarisActivity.class);
                startActivity(inventaris);
            }
        });
    }
}
