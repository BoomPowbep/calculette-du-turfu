package com.amelielaurent38.digital.testspinner.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amelielaurent38.digital.testspinner.R;
import com.amelielaurent38.digital.testspinner.activities.SecondActivity;
import com.amelielaurent38.digital.testspinner.listeners.PlanetListener;
import com.amelielaurent38.digital.testspinner.models.Planete;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder> {

    List<Planete> planetes;
    private PlanetListener listener;

    public PlanetAdapter(List<Planete> planetes , PlanetListener listener) {
        this.planetes = planetes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.planete_item, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindItem(planetes.get(position));
    }

    @Override
    public int getItemCount() {
        return planetes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mDescription;
        ImageView mImage;
        View view;
        Button mbuttonShare;

        MyViewHolder(View v) {
            super(v);
            this.view = itemView;
            mTitle = v.findViewById(R.id.textTitre);
            mDescription = v.findViewById(R.id.textDescription);
            mImage = v.findViewById(R.id.image);
            mbuttonShare = v.findViewById(R.id.buttonShare);

        }

        public void bindItem(final Planete planete) {
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), SecondActivity.class);
                    intent.putExtra("planet", planete);
                    v.getContext().startActivity(intent);
                }
            });

            mbuttonShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onShare(planete);
                }
            });
            mTitle.setText(planete.getTitre());
            mDescription.setText(planete.getDescription());
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").resize(1000, 300) // resizes the image to these dimensions (in pixel)
                    .centerCrop().into(mImage);
        }
    }
}
