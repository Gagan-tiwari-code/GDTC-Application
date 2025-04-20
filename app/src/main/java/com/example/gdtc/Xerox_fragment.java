package com.example.gdtc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Xerox_fragment extends Fragment {

  Button addbtns;
  EditText inputnumber;
  ListView listView;

  ArrayList<String> numberList;
  ArrayAdapter<String> adapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_xerox_fragment, container, false);

    addbtns = v.findViewById(R.id.addbtn);
    inputnumber = v.findViewById(R.id.numberinput);
    listView = v.findViewById(R.id.yourListView);

    // Load saved list before initializing adapter
    loadlist();

    // Setup adapter after loading data
    adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, numberList);
    listView.setAdapter(adapter);

    addbtns.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String number = inputnumber.getText().toString().trim();
        if (!number.isEmpty()) {
          numberList.add(number);
          adapter.notifyDataSetChanged();
          inputnumber.setText("");
          savelist();
        } else {
          Toast.makeText(getContext(), "Please enter the number", Toast.LENGTH_SHORT).show();
        }
      }
    });

    return v;
  }

  private void loadlist() {
    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
    Gson gson = new Gson();
    String json = sharedPreferences.getString("number_list", null);
    Type type = new TypeToken<ArrayList<String>>() {}.getType();
    numberList = gson.fromJson(json, type);
    if (numberList == null) {
      numberList = new ArrayList<>();
    }
  }

  private void savelist() {
    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mypre", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    Gson gson = new Gson();
    String json = gson.toJson(numberList);  // Java object to JSON string
    editor.putString("number_list", json);
    editor.apply();
  }
}
