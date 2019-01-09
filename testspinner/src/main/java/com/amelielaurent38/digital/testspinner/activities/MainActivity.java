package com.amelielaurent38.digital.testspinner.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.amelielaurent38.digital.testspinner.Adapter.MyAdapter;
import com.amelielaurent38.digital.testspinner.Adapter.PlanetAdapter;
import com.amelielaurent38.digital.testspinner.R;
import com.amelielaurent38.digital.testspinner.models.Planete;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_view);

        List<Planete> planetes = new ArrayList<>();
        planetes.add(new Planete("", "Terre", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Mars", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Mercure", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));

        RecyclerView recyclerView = findViewById(R.id.list_planet);
        PlanetAdapter adapter = new PlanetAdapter(planetes);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

       /* recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL ));*/
        /*String[] planetes = getResources().getStringArray(R.array.planetes);

        Spinner sp = findViewById(R.id.spinner);
        ArrayAdapter<String> dataAdapter = new MyAdapter(this,
                planetes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);*/
    }

}
