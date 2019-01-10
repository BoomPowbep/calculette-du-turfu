package com.amelielaurent38.digital.testspinner.network;

import com.amelielaurent38.digital.testspinner.models.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArticleService {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);


}
