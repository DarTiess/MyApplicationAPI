package com.example.myapplicationapi.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplicationapi.Article;
import com.example.myapplicationapi.MainActivity;
import com.example.myapplicationapi.NetworkService;
import com.example.myapplicationapi.R;
import com.example.myapplicationapi.RootObject;

import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.myapplicationapi.R.id.refresh;

public class RuNewsActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefresh;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerView.Adapter adapter;

    RootObject rootObject;
    private List<RootObject> rootObjectList;
    RootObject post;
    RootObject post2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ru_news);

            final TextView textView = findViewById(R.id.textView);

        mSwipeRefresh = (SwipeRefreshLayout) findViewById(refresh);
        mSwipeRefresh.setOnRefreshListener(this);

            NetworkService.getInstance()
                    .getJSONApi()
                    .getPosts("ru","e0644f2f58c24ad5a5ed9eb9963acffd" )
                    .enqueue(new Callback<RootObject>() {


                        @Override

                        public void onResponse(@NonNull Call<RootObject> call, @NonNull Response<RootObject> response) {

                            post = response.body();

                            textView.append("Общее колличество статей "+post.getTotalResults() + "\n");

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



        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.main_menu, menu);
            return true;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            Intent intent;
            int id = item.getItemId();
            switch(id){
                case R.id.news_ru:
                    mSwipeRefresh.setOnRefreshListener(this);
                    return true;
                case R.id.news_fr:
                    intent = new Intent(this, FranceNewsActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.news_us:
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }
    @Override
    public void onRefresh() {

        mSwipeRefresh.setRefreshing(true);

        mSwipeRefresh.setRefreshing(false);

    }

    public void onClickSport(View view) {

      Intent intent = new Intent(this, RuNewsSportActivity.class);
        startActivity(intent);
    }

    public void onClickTech(View view) {


    }
}
