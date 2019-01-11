package com.amelielaurent38.digital.newsletter.database;

import com.amelielaurent38.digital.newsletter.database.daos.ArticleDao;
import com.amelielaurent38.digital.newsletter.models.Article;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Article.class}, version = 3)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract ArticleDao articleDao();
}

