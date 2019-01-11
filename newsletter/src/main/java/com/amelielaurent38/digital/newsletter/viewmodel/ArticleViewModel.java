package com.amelielaurent38.digital.newsletter.viewmodel;

import android.widget.Toast;

import com.amelielaurent38.digital.newsletter.database.DatabaseHelper;
import com.amelielaurent38.digital.newsletter.models.Article;
import com.amelielaurent38.digital.newsletter.models.ArticleResult;
import com.amelielaurent38.digital.newsletter.network.ArticleService;
import com.amelielaurent38.digital.newsletter.utils.Constants;

import java.util.List;
import java.util.concurrent.Callable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import bolts.Task;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleViewModel extends ViewModel {

    private MutableLiveData<List<Article>> articlesLiveData;

    private MutableLiveData<Article> selected = new MutableLiveData<>();

    public LiveData<List<Article>> getArticles() {
        if (articlesLiveData == null) {
            articlesLiveData = new MutableLiveData<>();
            loadArticles();
        }
        return articlesLiveData;
    }

    private void loadArticles() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArticleService service = retrofit.create(ArticleService.class);

        Call<ArticleResult> articles_new = service.listArticles("us", Constants.API_KEY);
        articles_new.enqueue(new Callback<ArticleResult>() {
            @Override
            public void onResponse(Call<ArticleResult> call, Response<ArticleResult> response) {
                List<Article> articles = response.body().getArticles();
                articlesLiveData.setValue(articles);

                //On sauvegarde les articles dans la database
                saveNews(articles);

            }

            @Override
            public void onFailure(Call<ArticleResult> call, Throwable t) {
                System.out.println("Resultat Erreur" + t.getLocalizedMessage());
            }
        });
    }

    private void saveNews(final List<Article> articles) {
        Task.callInBackground(new Callable<Void>() {
            @Override
            public Void call() {
                DatabaseHelper.getDatabase().articleDao().insertAll(articles);
                return null;
            }
        });
    }

    public void setSelected(Article article) {
        selected.setValue(article);
    }

    public LiveData<Article> getSelected() {
        return selected;
    }

    /*void saveNews(final List<Article> articles) {
        //Pour instancier la base de données
        //Faire une tache en background
        Task.callInBackground(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                NewsDatabase db = Room.databaseBuilder(getContext(), NewsDatabase.class, "news-db")
                        .fallbackToDestructiveMigration()
                        .build();
                db.articleDao().insertAll(articles);
                return null;
            }
        }).continueWith(new Continuation<Void, Void>() {
            @Override
            public Void then(Task<Void> task) throws Exception {
                Toast.makeText(getContext(), "base de données modifiées", Toast.LENGTH_SHORT).show();
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR); //retourne sur le thread principal


    }*/
}
