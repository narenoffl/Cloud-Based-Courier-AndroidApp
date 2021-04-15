package com.example.couriercloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText namefield, passwordfield, phonefield;
        Button Signupbutton;

        namefield = findViewById(R.id.editTextTextPersonName);
        passwordfield = findViewById(R.id.editTextTextPassword);
        phonefield = findViewById(R.id.editTextPhone2);
        Signupbutton = findViewById(R.id.signupbutton);

        Signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String name = namefield.getText().toString();
                String password = passwordfield.getText().toString();
                String phonenumber = phonefield.getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name,password,phonenumber);

                reference.child(phonenumber).setValue(helperClass);

                Intent homepage = new Intent(Signup.this, HomePage.class);
                startActivity(homepage);

            }
        });

    }
}