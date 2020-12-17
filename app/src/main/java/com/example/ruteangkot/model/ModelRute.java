package com.example.ruteangkot.model;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class ModelRute{

    @SerializedName("rute_angkot")
    private ArrayList<RuteAngkotItem> ruteAngkot;

    public void setRuteAngkot(ArrayList<RuteAngkotItem> ruteAngkot){
        this.ruteAngkot = ruteAngkot;
    }

    public ArrayList<RuteAngkotItem> getRuteAngkot(){
        return ruteAngkot;
    }
}