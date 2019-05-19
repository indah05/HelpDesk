package com.example.fernanda.helpdeskbil_pjt.Model;

import java.util.List;

public class Value {
    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    String value;
    String message;
    int jml_progres;
    String jml_selesai;
    List<KeluhanModel> result;
    List<ListUnitModel> listunit;
    List<InventarisModel> resultInven;

    public List<InventarisModel> getResultInven() {
        return resultInven;
    }

    public List<ListUnitModel> getListunit() {
        return listunit;
    }

    public List<KeluhanModel> getResult() {
        return result;
    }

    public int getJml_progres() {
        return jml_progres;
    }

    public String getJml_selesai() {
        return jml_selesai;
    }

}
