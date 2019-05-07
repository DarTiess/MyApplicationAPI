package com.example.myapplicationapi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private List<Post> body;
    Post post;
    Post post2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
final TextView textView2=findViewById(R.id.textView2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolderApi api = retrofit.create(JSONPlaceHolderApi.class);
        api.getAllPost().enqueue(new Callback<Post>() {


            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                 post2 = response.body();


textView2.append(post2.getSource()+"\n");
                textView2.append(post2.getTitle() + "\n");

                textView2.append(post2.getDescription() + "\n");

                textView2.append(post2.getUrl() + "\n");




              //  textView2.append(body.toString()+"/n");
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {


                textView2.append("Error occurred while getting request!");

                t.printStackTrace();
            }
        });


        NetworkService.getInstance()
                .getJSONApi()
                .getAllPost()
                .enqueue(new Callback<Post>() {

           /*           @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {


                    }
                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable throwable) {
                        textView.append("Error occurred while getting request!");

                        throwable.printStackTrace();
                    }*/

                  @Override

                    public void onResponse( @NonNull Call<Post> call, @NonNull Response<Post> response) {

                        post = response.body();



                        textView.append(post.getTitle() + "\n");

                        textView.append(post.getDescription() + "\n");

                        textView.append(post.getUrl() + "\n");



                    }



                    @Override

                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {



                        textView.append("Error occurred while getting request!");

                        t.printStackTrace();

                    }

                });




    }



                }
