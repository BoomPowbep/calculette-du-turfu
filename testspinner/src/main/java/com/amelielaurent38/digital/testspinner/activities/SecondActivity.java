package com.amelielaurent38.digital.testspinner.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.amelielaurent38.digital.testspinner.R;
import com.amelielaurent38.digital.testspinner.models.Planete;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    private Planete mPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            mPlanet = b.getParcelable("planet");

            TextView mySecondtextView = findViewById(R.id.title_planet);
            mySecondtextView.setText(mPlanet.getTitre());

            TextView myDescriptiontextView = findViewById(R.id.description_planet);
            myDescriptiontextView.setText(mPlanet.getDescription());

            ImageView myImage = findViewById(R.id.image_planet);
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").resize(1000, 300) // resizes the image to these dimensions (in pixel)
                    .centerCrop().into(myImage);
        }
    }

}
