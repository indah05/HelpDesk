package com.example.fernanda.helpdeskbil_pjt.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fernanda.helpdeskbil_pjt.ListKeluhan.DetailKeluhanActivity;
import com.example.fernanda.helpdeskbil_pjt.Model.KeluhanModel;
import com.example.fernanda.helpdeskbil_pjt.R;

import java.util.List;

public class ListKeluhanAdapter extends RecyclerView.Adapter<ListKeluhanAdapter.ViewHolder>{

    private Context context;
    private List<KeluhanModel> keluhans;

    public ListKeluhanAdapter(Context context, List<KeluhanModel> keluhans) {
        this.context = context;
        this.keluhans = keluhans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_keluhan,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListKeluhanAdapter.ViewHolder holder, final int position) {
        KeluhanModel keluhan = keluhans.get(position);

        TextView status_keluhan = holder.status_keluhan;
        TextView jenis_keluhan = holder.jenis_keluhan;
        TextView txt_keluhan = holder.txt_keluhan;
        TextView tgl_keluhan = holder.tgl_keluhan;
        TextView nama_pengeluh = holder.unit;
        ImageView img_status_keluhan = holder.img_status_keluhan;
        String status = keluhan.getSTATUS();
        status_keluhan.setText(status);
//        if(status == "PROGRES"){
//            img_status_keluhan.setBackgroundResource(R.drawable.status_progress);
//            System.out.print("++++++++STATUS+++++++++++"+status);
//        } else{
//            img_status_keluhan.setBackgroundResource(R.drawable.status_selesai);
//        }
//        img_status_keluhan.setBackgroundResource(R.drawable.status_selesai);
        jenis_keluhan.setText(keluhan.getJENIS_KELUHAN());
        txt_keluhan.setText(keluhan.getKELUHAN());
        tgl_keluhan.setText(keluhan.getTGL_KELUHAN());
        nama_pengeluh.setText(keluhan.getUNIT());

        holder.cv_list_keluhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailKeluhanActivity.class);
                intent.putExtra(DetailKeluhanActivity.EXTRA_ID, keluhans.get(position).getIDKELUHAN());
                intent.putExtra(DetailKeluhanActivity.EXTRA_STATUS, keluhans.get(position).getSTATUS());
                intent.putExtra(DetailKeluhanActivity.EXTRA_JENIS_KELUHAN, keluhans.get(position).getJENIS_KELUHAN());
                intent.putExtra(DetailKeluhanActivity.EXTRA_KELUHAN, keluhans.get(position).getKELUHAN());
                intent.putExtra(DetailKeluhanActivity.EXTRA_TGL_KELUHAN, keluhans.get(position).getTGL_KELUHAN());
                intent.putExtra(DetailKeluhanActivity.EXTRA_UNIT, keluhans.get(position).getUNIT());
                intent.putExtra(DetailKeluhanActivity.EXTRA_PELAKSANA, keluhans.get(position).getIDPEGAWAI());
                intent.putExtra(DetailKeluhanActivity.EXTRA_TGL_SELESAI, keluhans.get(position).getTGL_SELESAI());
                intent.putExtra(DetailKeluhanActivity.EXTRA_NAMA_PENGELUH, keluhans.get(position).getNAMA());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return keluhans.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView status_keluhan, jenis_keluhan, txt_keluhan, tgl_keluhan, unit;
        CardView cv_list_keluhan;
        ImageView img_status_keluhan;

        public ViewHolder(View itemView) {
            super(itemView);
            cv_list_keluhan = itemView.findViewById(R.id.cvListKeluhan);
            status_keluhan = itemView.findViewById(R.id.txt_status_keluhan);
            jenis_keluhan = itemView.findViewById(R.id.txt_jenis_keluhan);
            txt_keluhan = itemView.findViewById(R.id.txt_keluhan);
            tgl_keluhan = itemView.findViewById(R.id.txt_tgl_keluhan);
            unit = itemView.findViewById(R.id.txt_unit);
            img_status_keluhan = itemView.findViewById(R.id.img_status_keluhan);
        }
    }

}
