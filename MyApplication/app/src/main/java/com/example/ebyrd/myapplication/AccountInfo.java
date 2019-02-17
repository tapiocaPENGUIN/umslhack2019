package com.example.ebyrd.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

public class AccountInfo extends AppCompatActivity {

    ProgressBar progBar;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        TextView Events = findViewById(R.id.Events);
        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startintent = new Intent(getApplicationContext(), Findwork.class);
                // show how to pass information to the secondactivity
                startActivity(startintent);
            }

        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();

//        DocumentReference user = db.collection("users").document("IRqCoZ3A6NcTwmiW1rrX");
//        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()){
//                    DocumentSnapshot doc = task.getResult();
//
//
//
//                    TextView tview = (TextView) findViewById(R.id.textView2);
//
//                    tview.setText(doc.get("first").toString());
//                }
//            }
//        })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                    }
//                });
//    }

        String name = "a string";
        CollectionReference citiesRef = db.collection("Volunteers");
        Query query = citiesRef.whereEqualTo("Location", "a string");
        TextView tview = (TextView) findViewById(R.id.textView2);

        try {
            String text = query.get().toString();
            tview.setText(text);
        }
        catch (Exception e){
            System.out.println(e);

        }



        DocumentReference docRef = db.collection("Volunteers").document("a string");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {


                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });








        //Number of Points
        int pts = 20;


//        progBar=(ProgressBar)findViewById(R.id.progressBar);
//        progBar.setProgress(20);
//        progBar.setScaleY(10f);
//
//        progBar.setBackgroundColor(Color.parseColor("#B6B6B4"));




   // private void setSupportActionBar(Toolbar toolbar) {
    }






    }


