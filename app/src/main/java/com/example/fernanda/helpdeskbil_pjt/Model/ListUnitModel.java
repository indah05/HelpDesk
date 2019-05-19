package com.example.fernanda.helpdeskbil_pjt.Model;

public class ListUnitModel {
    String unit;
    int id;

    public ListUnitModel(int id, String unit){
        this.id = id;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getUnit();
    }

}