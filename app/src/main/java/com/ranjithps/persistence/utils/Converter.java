package com.ranjithps.persistence.utils;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ranjithps.persistence.entity.Language;


import org.json.JSONObject;

import java.util.List;


public class Converter {

    @TypeConverter
    public List<String> restoreList(String listAsString) {
        return new Gson().fromJson(listAsString, new TypeToken<List<String>>() {}.getType());
    }

    @TypeConverter
    public String saveList(List<String> listOfString) {
        return new Gson().toJson(listOfString);
    }

    @TypeConverter
    public String saveObject(JSONObject value) {
        return value == null ? null : value.toString();
    }

    @TypeConverter
    public JSONObject objectToJSONObject(String jsonString) {
        return new Gson().fromJson(jsonString,new TypeToken<JSONObject>() {}.getType());
    }

    @TypeConverter
    public String saveLanguageList(List<Language> listofLanguage) {
        return new Gson().toJson(listofLanguage);
    }

    @TypeConverter
    public List<Language> retrieveLanguageList(String listOfLanguagesAsString) {
        return new Gson().fromJson(listOfLanguagesAsString, new TypeToken<List<Language>>() {}.getType());
    }
}
