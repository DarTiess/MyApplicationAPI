package com.example.myapplicationapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source{
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}