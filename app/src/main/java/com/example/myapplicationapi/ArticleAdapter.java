package com.example.myapplicationapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
 private Source source;
 private RootObject rootObject;
 List<Article> articleList;

 public ArticleAdapter (RootObject rootObject){
     this.rootObject=rootObject;
     articleList=rootObject.getArticles();
 }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Article article = articleList.get(position);

        holder.title.setText(article.getTitle());
        holder.url.setText(article.getUrl());
        holder.description.setText( article.getDescription());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView url;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            url = itemView.findViewById(R.id.url);
            description = itemView.findViewById(R.id.description);
        }
    }
}
