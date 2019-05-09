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
 List<RootObject> rootList;

 public ArticleAdapter (List<RootObject> rootList){
     this.rootList=rootList;

 }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       RootObject rootObject = rootList.get(position);

        holder.title.setText(rootObject.getStatus());
        holder.url.setText(rootObject.getTotalResults());
        holder.description.setText( rootObject.getArticles().iterator().next().getTitle());
    }

    @Override
    public int getItemCount() {
        return rootList.size();
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
