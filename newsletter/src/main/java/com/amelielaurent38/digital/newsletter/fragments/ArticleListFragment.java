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
import com.amelielaurent38.digital.newsletter.models.ArticleResult;
import com.amelielaurent38.digital.newsletter.network.ArticleService;
import com.amelielaurent38.digital.newsletter.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleListFragment extends Fragment implements ShareListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_list_fragment, container, false);

        final RecyclerView recyclerView = view.findViewById(R.id.list_article);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArticleService service = retrofit.create(ArticleService.class);

        Call<ArticleResult> articles_new = service.listArticles("us", Constants.API_KEY);
        articles_new.enqueue(new Callback<ArticleResult>() {
            @Override
            public void onResponse(Call<ArticleResult> call, Response<ArticleResult> response) {
                System.out.println("Resultat Success" + response.body());
                ArticleAdapter adapter = new ArticleAdapter(response.body().getArticles(), ArticleListFragment.this);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArticleResult> call, Throwable t) {
                System.out.println("Resultat Erreur" + t.getLocalizedMessage());
            }
        });

        return view;
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
