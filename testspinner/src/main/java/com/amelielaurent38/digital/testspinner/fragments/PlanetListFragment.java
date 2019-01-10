package com.amelielaurent38.digital.testspinner.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amelielaurent38.digital.testspinner.Adapter.PlanetAdapter;
import com.amelielaurent38.digital.testspinner.R;
import com.amelielaurent38.digital.testspinner.listeners.PlanetListener;
import com.amelielaurent38.digital.testspinner.models.Planete;

import java.util.ArrayList;
import java.util.List;

public class PlanetListFragment extends Fragment implements PlanetListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.planet_list_fragment, container, false);

        List<Planete> planetes = new ArrayList<>();
        planetes.add(new Planete("", "Terre", "La planete terre blblab"));
        planetes.add(new Planete("", "Mars", "La planete mars"));
        planetes.add(new Planete("", "Mercure", "La planete Mercure"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));
        planetes.add(new Planete("", "Planet 1", "blab ablaks nksnd dskjdklskmds sdkjdklklmdkksdsd"));

        RecyclerView recyclerView = view.findViewById(R.id.list_planet);
        PlanetAdapter adapter = new PlanetAdapter(planetes, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void showPlanetDetail(){
        PlanetDetailFragment fragment = new PlanetDetailFragment();

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void onShare(Planete planete) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "La planete " + planete.getTitre() + " est trop bien");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }


}
