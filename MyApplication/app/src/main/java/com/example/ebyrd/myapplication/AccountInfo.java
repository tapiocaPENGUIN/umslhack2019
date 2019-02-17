package com.example.ebyrd.myapplication;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;



public class AccountInfo extends AppCompatActivity {

    private static final String TAG = "FireLog";


    private FirebaseFirestore mFirestore;

    FirebaseFirestore db = FirebaseFirestore.getInstance();




    //    ProgressBar progBar;
//    private static final String TAG = "MainActivity";
//
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        CollectionReference citiesRef = db.collection("users");
//        Query query = citiesRef.whereEqualTo("first", "Scooby");
//
//        query.get();
//
//        TextView tview = (TextView) findViewById(R.id.textView2);
////
//        tview.setText(query.get().toString());
//
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
//
////        String name = "a string";
////        CollectionReference citiesRef = db.collection("Volunteers");
////        Query query = citiesRef.whereEqualTo("Location", "a string");
////        TextView tview = (TextView) findViewById(R.id.textView2);
//
//
//
//    FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//    CollectionReference citiesRef = db.collection("users");
//    Query query = citiesRef.whereEqualTo("first", "Scooby");
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        //Number of Points
//        int pts = 20;


//        progBar=(ProgressBar)findViewById(R.id.progressBar);
//        progBar.setProgress(20);
//        progBar.setScaleY(10f);
//
//        progBar.setBackgroundColor(Color.parseColor("#B6B6B4"));


        // private void setSupportActionBar(Toolbar toolbar) {





        //start new code


        mFirestore = FirebaseFirestore.getInstance();
        mFirestore.collection("Test-Users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e!= null){
                    Log.d(TAG,"Error : " + e.getMessage());
                }

                for (DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){

                        String userId = doc.getDocument().getId();



                        DocumentReference user = db.collection("Test-Users").document(userId);
                        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                                if (task.isSuccessful()){
                                    DocumentSnapshot doc = task.getResult();

                                    TextView tview = (TextView) findViewById(R.id.textView4);
                                    TextView tview2 = (TextView) findViewById(R.id.textView5);

                                    tview2.setText("Points: " + doc.get("Points").toString());
                                    tview.setText("Welcome, " + doc.get("first").toString());

                                }
                            }
                        });

                    }




//end




                    TextView Events = (TextView) findViewById(R.id.Events);
                    Events.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent startintent = new Intent(getApplicationContext(), Findwork.class);
                            // show how to pass information to the secondactivity
                            startActivity(startintent);
                        }

                    });











                }
            }

        });






































    }





}






