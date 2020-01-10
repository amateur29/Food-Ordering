package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> cuisineNames = new ArrayList<>();
    private ArrayList<String> mImageURLs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mImageURLs.add("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80");
        mNames.add("Restaurant 1");
        cuisineNames.add("Cuisine 1");

        mImageURLs.add("https://images.unsplash.com/photo-1502301103665-0b95cc738daf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80");
        mNames.add("Restaurant 2");
        cuisineNames.add("Cuisine 2");

        mImageURLs.add("https://images.unsplash.com/photo-1467003909585-2f8a72700288?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80");
        mNames.add("Restaurant 3");
        cuisineNames.add("Cuisine 3");

        initRecyclerView();
    }

    private void initRecyclerView() {

        //Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerview = findViewById(R.id.recycler_view);
        com.example.foodordering.RecyclerViewAdapter adapter = new com.example.foodordering.RecyclerViewAdapter(mNames, mImageURLs,cuisineNames,this);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}
