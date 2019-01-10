package com.amelielaurent38.digital.newsletter.activities;

import android.os.Bundle;

import com.amelielaurent38.digital.newsletter.R;
import com.amelielaurent38.digital.newsletter.fragments.ArticleListFragment;
import com.amelielaurent38.digital.newsletter.models.Article;
import com.amelielaurent38.digital.newsletter.models.ArticleResult;
import com.amelielaurent38.digital.newsletter.network.ArticleService;
import com.amelielaurent38.digital.newsletter.utils.Constants;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArticleService service = retrofit.create(ArticleService.class);

        Call<ArticleResult> articles_new = service.listArticles("us", Constants.API_KEY);
        articles_new.enqueue(new Callback<ArticleResult>() {
            @Override
            public void onResponse(Call<ArticleResult> call, Response<ArticleResult> response) {
                response.body().getArticles();
                System.out.println("Resultat Success" + response.body());
            }

            @Override
            public void onFailure(Call<ArticleResult> call, Throwable t) {
                System.out.println("Resultat Erreur" + t.getLocalizedMessage());
            }
        });


        showArticleList();
    }

    private void showArticleList() {
        ArticleListFragment fragment = new ArticleListFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
