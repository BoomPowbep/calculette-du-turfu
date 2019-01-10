package com.amelielaurent38.digital.newsletter.network;

import com.amelielaurent38.digital.newsletter.models.Article;
import com.amelielaurent38.digital.newsletter.models.ArticleResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleService {

    @GET("top-headlines")
    Call<ArticleResult> listArticles(@Query("country") String country, @Query("apiKey") String apiKey);

}
