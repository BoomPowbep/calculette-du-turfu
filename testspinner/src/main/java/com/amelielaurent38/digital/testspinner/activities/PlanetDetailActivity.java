package com.amelielaurent38.digital.testspinner.activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amelielaurent38.digital.testspinner.R;
import com.amelielaurent38.digital.testspinner.models.Planete;
import com.squareup.picasso.Picasso;

public class PlanetDetailActivity extends AppCompatActivity {

    private Planete mPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_detail_activity);

        Button alert = findViewById(R.id.button_alert);

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

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(PlanetDetailActivity.this);

// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("Coucou")
                        .setTitle("Hey")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(PlanetDetailActivity.this, "OK", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(PlanetDetailActivity.this, "Nope", Toast.LENGTH_SHORT).show();
                            }
                        });


// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

}
