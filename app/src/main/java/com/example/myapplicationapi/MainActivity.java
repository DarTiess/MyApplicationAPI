package com.example.myapplicationapi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerView.Adapter adapter;

    RootObject rootObject;
    private List<RootObject> rootObjectList;
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


        NetworkService.getInstance()
                .getJSONApi()
                .getPosts("us","e0644f2f58c24ad5a5ed9eb9963acffd" )
                .enqueue(new Callback<RootObject>() {


                    @Override

                    public void onResponse( @NonNull Call<RootObject> call, @NonNull Response<RootObject> response) {

                       post = response.body();

                        textView.append("Amount "+post.getTotalResults() + "\n");

                        Iterator<Article> iterator=post.getArticles().iterator();
                        int i=0;
                        while(iterator.hasNext()) {
                            i++;

                            textView.append("\n"+i+") "+iterator.next().getTitle() + "\n");

                        }


                    }



                    @Override

                    public void onFailure(@NonNull Call<RootObject> call, @NonNull Throwable t) {



                 textView.append("Error occurred while getting request!");

                        t.printStackTrace();

                    }

                });




    }



}
