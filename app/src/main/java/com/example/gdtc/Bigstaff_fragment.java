package com.example.gdtc;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Bigstaff_fragment extends Fragment {

    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bigstaff_fragment, container, false);

        floatingActionButton = v.findViewById(R.id.addstafffab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to AddBiggStaffFragement
                Fragment addStaffFragment = new AddBiggStaffFragement();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.biggstaff_container, addStaffFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}
