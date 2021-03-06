package com.amelielaurent38.digital.newsletter.database.daos;

import com.amelielaurent38.digital.newsletter.models.Article;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM article")
    List<Article> getAll();

    @Query("SELECT * FROM article WHERE article_title LIKE :title")
    Article findByTitle(String title);

    @Insert
    void insertAll(List<Article> articles);

    @Delete
    void delete(Article article);
}
