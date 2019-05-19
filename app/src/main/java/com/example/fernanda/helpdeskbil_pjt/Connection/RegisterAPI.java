package com.example.fernanda.helpdeskbil_pjt.Connection;

import com.example.fernanda.helpdeskbil_pjt.Model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar(@Field("nama") String nama,
                       @Field("id_unit") int id_unit,
                       @Field("keluhan") String keluhan,
                       @Field("idjenis_keluhan") int idjenis_keluhan,
                       @Field("status") String status);
    @GET("view.php")
    Call<Value> view();

    @GET("view_selesai.php")
    Call<Value> view_selesai();

    @GET("list_unit.php")
    Call<Value> listUNIT();

    @GET("list_jenis_keluhan.php")
    Call<Value> listJenisKeluhan();

    @GET("count_progres.php")
    Call<Value> count_progres();

    @GET("view_inventaris.php")
    Call<Value> view_inventaris();
}
