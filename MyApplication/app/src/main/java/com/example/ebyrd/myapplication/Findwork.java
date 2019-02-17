package com.example.ebyrd.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Findwork extends AppCompatActivity {

    ListView myListView;
    String[] locations;
    String[] points;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findwork);
        buildLookForWorkList();
    }

    public void buildLookForWorkList()
    {
        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        locations = res.getStringArray(R.array.Locations);
        points = res.getStringArray(R.array.Points);
        descriptions = res.getStringArray(R.array.Descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, locations, points, descriptions);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), WorkDetailActivity.class);
                showDetailActivity.putExtra("INDEX",position);
                startActivity(showDetailActivity);
            }
        });

    }



}
