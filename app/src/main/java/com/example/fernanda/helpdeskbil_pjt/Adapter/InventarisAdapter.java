package com.example.fernanda.helpdeskbil_pjt.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fernanda.helpdeskbil_pjt.Model.KeluhanModel;
import com.example.fernanda.helpdeskbil_pjt.R;

import java.util.List;

public class InventarisAdapter extends RecyclerView.Adapter<InventarisAdapter.ViewHolder>{

    private Context ctx;
    private List<KeluhanModel> inventaris;

    public InventarisAdapter(Context context, List<KeluhanModel> inventaris){
        this.ctx = context;
        this.inventaris = inventaris;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_inventaris, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        KeluhanModel inventari = inventaris.get(position);
        TextView txt_kondisi_inventaris = holder.txt_kondisi_inventaris;
        TextView txt_jenis_komputer = holder.txt_jenis_komputer;
        TextView txt_spesifikasi = holder.txt_spesifikasi;
        TextView txt_tahun_pembelian = holder.txt_tahun_pembelian;
        TextView txt_unit_invent = holder.txt_unit_invent;

        txt_kondisi_inventaris.setText(inventari.getKONDISI());
        txt_jenis_komputer.setText(inventari.getJENIS_KOMPUTER());
        txt_spesifikasi.setText(inventari.getSPESIFIKASI());
        txt_tahun_pembelian.setText(inventari.getTAHUN_PEMBELIAN());
        txt_unit_invent.setText(inventari.getUNIT());

    }

    @Override
    public int getItemCount() {
        return inventaris.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_kondisi_inventaris, txt_jenis_komputer, txt_spesifikasi, txt_tahun_pembelian, txt_unit_invent;
        CardView cv_list_inventaris;
        ImageView img_kondisi;
        public ViewHolder(View itemView) {
            super(itemView);
            cv_list_inventaris = itemView.findViewById(R.id.cvListInventaris);
            txt_kondisi_inventaris = itemView.findViewById(R.id.txt_kondisi_inventaris);
            txt_jenis_komputer = itemView.findViewById(R.id.txt_jenis_komputer);
            txt_spesifikasi = itemView.findViewById(R.id.txt_spesifikasi);
            txt_tahun_pembelian = itemView.findViewById(R.id.txt_tahun_pembelian);
            txt_unit_invent = itemView.findViewById(R.id.txt_unit_inventaris);
            img_kondisi = itemView.findViewById(R.id.img_kondisi);
        }
    }
}
