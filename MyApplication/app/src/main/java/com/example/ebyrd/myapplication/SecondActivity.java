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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "My Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Button submit = (Button) findViewById(R.id.submit);
        final Button gotologin = (Button) findViewById(R.id.GoToLogin);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

        final EditText fname = (EditText) findViewById(R.id.fname);
        final EditText lname = (EditText) findViewById(R.id.lname);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final EditText uname = (EditText) findViewById(R.id.uname);
        final EditText email = (EditText) findViewById(R.id.uemail);
        final EditText zip = (EditText) findViewById(R.id.zip);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText DOB = (EditText) findViewById(R.id.dob);



        final String _fname = fname.getText().toString();
        final String _lname = lname.getText().toString();
        final String _phone = phone.getText().toString();
        final String _uname = uname.getText().toString();
        final String _email = email.getText().toString();
        final String _zip = zip.getText().toString();
        final String _password = password.getText().toString();
        final String _DOB = DOB.getText().toString();
        final String _submit = submit.getText().toString();




                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> user = new HashMap<>();
                user.put("first", _fname);
                user.put("last", _lname);
                user.put("Phone", _phone);
                user.put("Username", _uname);
                user.put("email", _email);
                user.put("Zip Code", _zip);
                user.put("Password", _password);
                user.put("DOB", _DOB);
                user.put("Points", 0);

              //  DocumentReference newUserRef = db.collection("Test-Users").document("Name");
                //newUserRef.set(user);

                db.collection("Test-Users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                System.out.print("Success");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                System.out.print("Failure");
                            }
                        });

                Intent startintent = new Intent(getApplicationContext(), AccountInfo.class);
                // show how to pass information to the secondactivity
                startActivity(startintent);

            }
        });


        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startintent = new Intent(getApplicationContext(),Login_Activity.class);
                // show how to pass information to the secondactivity
                startActivity(startintent);
            }

        });

    }


  /*  public void createUser(){
        SecondActivity sa = new SecondActivity();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("first", _fname);
        user.put("last", lname.getText());
        user.put("Phone", phone.getText());
        user.put("Username", uname.getText());
        user.put("email", email.getText());
        user.put("Zip Code", zip.getText());
        user.put("Password", password.getText());
        user.put("DOB", DOB.getText());
        user.put("Points", 0);

        db.collection("Test-Users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.print("Success");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.print("Failure");
                    }
                });
    }*/

}
