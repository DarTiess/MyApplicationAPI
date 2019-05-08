package com.example.myapplicationapi;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerView.Adapter adapter;

    RootObject rootObject;
    private List<RootObject> body;
    RootObject post;
    RootObject post2;
    TextView title;
    TextView url;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        final TextView textView2=findViewById(R.id.textView2);

        //   recyclerView = findViewById(R.id.article_recycle_view);
        //   linearLayoutManager = new LinearLayoutManager(this);
        // recyclerView.setLayoutManager(linearLayoutManager);

        //    adapter = new ArticleAdapter(rootObject);
        //   recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolderApi api = retrofit.create(JSONPlaceHolderApi.class);
        api.getAllPost().enqueue(new Callback<RootObject>() {


            @Override
            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                // post = response.body();



                //  recyclerView.getAdapter().notifyDataSetChanged();


                post2 = response.body();


                textView2.append(post2.getArticles()+"\n");
                textView2.append(post2.getTotalResults() + "\n");

                textView2.append(post2.getStatus() + "\n");



                // textView2.append(body.toString()+"/n");
            }

            @Override
            public void onFailure(Call<RootObject> call, Throwable t) {


                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });


        NetworkService.getInstance()
                .getJSONApi()
                .getPosts("us","e0644f2f58c24ad5a5ed9eb9963acffd" )
                .enqueue(new Callback<RootObject>() {

                    /*           @Override
                             public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {


                             }
                             @Override
                             public void onFailure(Call<List<Post>> call, Throwable throwable) {
                                 textView.append("Error occurred while getting request!");

                                 throwable.printStackTrace();
                             }
         */
                    @Override

                    public void onResponse( @NonNull Call<RootObject> call, @NonNull Response<RootObject> response) {

                        post = response.body();



                        textView.append("\n"+post.getStatus() + "\n");

                        textView.append(post.getTotalResults() + "\n");

                        textView.append(post.getArticles().iterator().next().getTitle()+ "\n");



                    }



                    @Override

                    public void onFailure(@NonNull Call<RootObject> call, @NonNull Throwable t) {



                        textView.append("Error occurred while getting request!");

                        t.printStackTrace();

                    }

                });




    }



}
