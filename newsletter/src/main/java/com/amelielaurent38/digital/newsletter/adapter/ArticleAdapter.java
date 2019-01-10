package com.amelielaurent38.digital.newsletter.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amelielaurent38.digital.newsletter.R;
import com.amelielaurent38.digital.newsletter.models.Article;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    List<Article> articles;

    public ArticleAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.article_model, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindItem(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mDescription;
        ImageView mImage;
        View view;
        //Button mbuttonShare;

        MyViewHolder(View v) {
            super(v);
            this.view = itemView;
            mTitle = v.findViewById(R.id.textTitre);
            mDescription = v.findViewById(R.id.textDescription);
            mImage = v.findViewById(R.id.image);
            //mbuttonShare = v.findViewById(R.id.buttonShare);

        }

        public void bindItem(final Article article) {
            /*view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PlanetDetailActivity.class);
                    intent.putExtra("planet", planete);
                    v.getContext().startActivity(intent);
                }
            });

            mbuttonShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onShare(planete);
                }
            });*/

            mTitle.setText(article.getTitle());
            mDescription.setText(article.getDescription());
           /* Picasso.get().load("http://i.imgur.com/DvpvklR.png").resize(1000, 300) // resizes the image to these dimensions (in pixel)
                    .centerCrop().into(mImage);*/
        }
    }
}
