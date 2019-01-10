package com.amelielaurent38.digital.testspinner.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amelielaurent38.digital.testspinner.R;
import com.amelielaurent38.digital.testspinner.activities.PlanetDetailActivity;
import com.amelielaurent38.digital.testspinner.models.Planete;
import com.squareup.picasso.Picasso;

public class PlanetDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.planet_detail_fragment, container, false);

        Button alert = view.findViewById(R.id.button_alert);

        Bundle b = getActivity().getIntent().getExtras();

        if (b != null) {
            Planete planet = b.getParcelable("planet");

            TextView mySecondtextView = view.findViewById(R.id.title_planet);
            mySecondtextView.setText(planet.getTitre());

            TextView myDescriptiontextView = view.findViewById(R.id.description_planet);
            myDescriptiontextView.setText(planet.getDescription());

            ImageView myImage = view.findViewById(R.id.image_planet);
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").resize(1000, 300) // resizes the image to these dimensions (in pixel)
                    .centerCrop().into(myImage);
        }

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("Coucou")
                        .setTitle("Hey")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "Nope", Toast.LENGTH_SHORT).show();
                            }
                        });


// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    return view;

    }



}
