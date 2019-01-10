package com.amelielaurent38.digital.newsletter.network;

import com.amelielaurent38.digital.newsletter.models.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArticleService {

    @GET("users/{user}/repos")
    Call<List<Article>> listRepos(@Path("user") String user);

}
