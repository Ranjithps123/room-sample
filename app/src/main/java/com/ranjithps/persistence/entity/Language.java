package com.ranjithps.persistence.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Language implements Serializable {
    @SerializedName("native")
    private String nativeLanguage;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    public void setJsonMemberNative(String jsonMemberNative) {
        this.nativeLanguage = jsonMemberNative;
    }

    public String getJsonMemberNative() {
        return nativeLanguage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "Language{" +
                        "native = '" + nativeLanguage + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
