package com.ranjithps.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ranjithps.persistence.utils.Converter;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "configuration")
public class Config implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    @SerializedName("peer5")
    private Boolean peer5;
    @ColumnInfo
    @SerializedName("moatEnable")
    private String moatEnable;
    @ColumnInfo
    @TypeConverters(Converter.class)
    @SerializedName("languages")
    private List<Language> languages;

    @ColumnInfo
    @SerializedName("allowed_countries")
    @TypeConverters(Converter.class)
    private List<String> countries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getPeer5() {
        return peer5;
    }

    public void setPeer5(Boolean peer5) {
        this.peer5 = peer5;
    }

    public String getMoatEnable() {
        return moatEnable;
    }

    public void setMoatEnable(String moatEnable) {
        this.moatEnable = moatEnable;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }


}
