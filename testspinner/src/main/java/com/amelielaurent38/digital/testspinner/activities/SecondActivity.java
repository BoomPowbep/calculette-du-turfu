package com.amelielaurent38.digital.testspinner.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.amelielaurent38.digital.testspinner.R;
import com.amelielaurent38.digital.testspinner.models.Planete;

public class SecondActivity extends AppCompatActivity {

    private Planete mPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            mPlanet = b.getParcelable("planet");

            TextView MySecondtextView = findViewById(R.id.title_planet);
            MySecondtextView.setText(mPlanet.getTitre());

            TextView MyDescriptiontextView = findViewById(R.id.description_planet);
            MyDescriptiontextView.setText(mPlanet.getDescription());
        }
    }

}
