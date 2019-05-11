package com.example.myapplicationapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {


    @GET("https://newsapi.org/v2/top-headlines")
    Call<RootObject> getPosts(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines?country=us&apiKey=e0644f2f58c24ad5a5ed9eb9963acffd")
    Call<RootObject> getAllPost();

    @GET("https://newsapi.org/v2/top-headlines")
    Call<RootObject> getCategori(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );
}
