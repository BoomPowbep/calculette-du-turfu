package com.amelielaurent38.digital.testspinner.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amelielaurent38.digital.testspinner.R;

public class MyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MyAdapter(Context context, String[] values){
        super(context, R.layout.line_item, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, View convertview, @NonNull ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.line_item, parent, false);
        TextView textView = rowView.findViewById(R.id.label);
        ImageView imageView = rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        imageView.setImageResource(R.drawable.ic_arrow);

        return rowView;
    }
}
