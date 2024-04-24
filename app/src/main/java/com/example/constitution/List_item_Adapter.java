package com.example.constitution;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class List_item_Adapter extends ArrayAdapter<List_item> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<List_item> states;

    public List_item_Adapter(Context context, int resource, List<List_item> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = inflater.inflate(this.layout, parent, false);
        TextView text = view.findViewById(R.id.item_text);

        List_item state = states.get(position);
        text.setText(state.getText());

        return view;
    }
}
