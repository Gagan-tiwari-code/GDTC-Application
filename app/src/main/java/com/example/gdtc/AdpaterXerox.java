package com.example.gdtc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AdpaterXerox extends ArrayAdapter<String> {

    Context context;
    List<String> items;


    public AdpaterXerox(@NonNull Context context, List<String> items) {
        super(context,R.layout.containerbar,items);
        this.context = context;
        this.items = items;
    }


  /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.containerbar, parent, false);
        TextView textView = view.findViewById(R.id.numberview);
       // ImageView imageView = view.findViewById(R.id.item_icon);
    } */
}
