package com.example.gdtc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class AddBiggStaffFragement extends Fragment {

    String[] item = {"Indian Bank", "Punjab Bank", "Apna Sahkari"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapteritem;
 //FragmentManager fragmentManager = getChildFragmentManager();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_bigg_staff_fragement, container, false);

       autoCompleteTextView = v.findViewById(R.id.auto_completetext);

        // Fix: Provide the string array to the adapter
        adapteritem = new ArrayAdapter<>(getContext(), R.layout.list_item, item);
        autoCompleteTextView.setAdapter(adapteritem);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String selectedItem = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "You selected: " + selectedItem, Toast.LENGTH_SHORT).show();
             }
        });

        return v;
    }
}
