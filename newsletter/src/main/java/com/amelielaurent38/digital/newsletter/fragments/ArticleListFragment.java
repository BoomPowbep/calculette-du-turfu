package com.amelielaurent38.digital.newsletter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amelielaurent38.digital.newsletter.R;
import com.amelielaurent38.digital.newsletter.adapter.ArticleAdapter;
import com.amelielaurent38.digital.newsletter.models.Article;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_list_fragment, container, false);

        List<Article> articles = new ArrayList<>();
        articles.add(new Article("", "Terre", "La planete terre blblab"));
        articles.add(new Article("", "Mars", "La planete mars"));
        articles.add(new Article("", "Mercure", "La planete Mercure"));
        articles.add(new Article("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));


        RecyclerView recyclerView = view.findViewById(R.id.list_article);
        ArticleAdapter adapter = new ArticleAdapter(articles);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
