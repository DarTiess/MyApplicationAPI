package com.example.myapplicationapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootObject {
    @SerializedName("status")
    @Expose
    public String status ;

    @SerializedName("totalResults")
    @Expose

    public int totalResults ;

    public List<Article> articles ;


    public String getStatus(){
        return status;
    }
    public int getTotalResults(){
        return totalResults;
    }

    public List<Article> getArticles(){
        return articles;
    }

    public void setStatus(String status) {
        this.status= status;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults= totalResults;
    }
    public void setArticles(List<Article> articles) {
        this.articles= articles;
    }
}
