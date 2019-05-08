package com.example.myapplicationapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    private Source source;
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("title")
    @Expose
    private String title;




    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url= url;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title= title;
    }
    public Source getSource(){return source;}
}
