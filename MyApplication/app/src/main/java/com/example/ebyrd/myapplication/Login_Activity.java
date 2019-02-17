package com.example.ebyrd.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);


        final EditText log_uname = (EditText) findViewById(R.id.loginuname);
        final EditText log_pass = (EditText) findViewById(R.id.loginpass);
        final Button log_login = (Button) findViewById(R.id.login);
        final Button log_register = (Button) findViewById(R.id.GoToSignUp);

        final String _log_uname = log_uname.getText().toString();
        final String _log_pass = log_pass.getText().toString();

        log_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {





            }
        });

        log_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startintent = new Intent(getApplicationContext(),SecondActivity.class);
                // show how to pass information to the secondactivity
                startActivity(startintent);
            }

        });
    }


/*        DocumentReference docRef = db.collection("Test-Users").document();
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()){
                        Log.d(TAG, "DocumentSnspshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });*/

}
