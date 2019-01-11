package com.amelielaurent38.digital.newsletter.activities;

import android.os.Bundle;

import com.amelielaurent38.digital.newsletter.R;
import com.amelielaurent38.digital.newsletter.database.DatabaseHelper;
import com.amelielaurent38.digital.newsletter.fragments.ArticleListFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper.init(this);

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
