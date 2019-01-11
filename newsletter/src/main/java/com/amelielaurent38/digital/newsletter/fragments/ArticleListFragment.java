package com.amelielaurent38.digital.newsletter.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amelielaurent38.digital.newsletter.R;
import com.amelielaurent38.digital.newsletter.adapter.ArticleAdapter;
import com.amelielaurent38.digital.newsletter.listener.ShareListener;
import com.amelielaurent38.digital.newsletter.models.Article;
import com.amelielaurent38.digital.newsletter.viewmodel.ArticleViewModel;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleListFragment extends Fragment implements ShareListener {
    private RecyclerView recyclerView;
    private ArticleViewModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Créer ou récuperer l'instance du viewmodel pour ce fragment
        model = ViewModelProviders.of(this).get(ArticleViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_list_fragment, container, false);
        recyclerView = view.findViewById(R.id.list_article);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model.getArticles().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                ArticleAdapter adapter = new ArticleAdapter(articles, ArticleListFragment.this);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onShare(Article article) {
        Toast.makeText(getContext(), "SHARRREEE", Toast.LENGTH_SHORT).show();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Cet article " + article.getTitle() + " est trop bien");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }


}

//Pull to refresh