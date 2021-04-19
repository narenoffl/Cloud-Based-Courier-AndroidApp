package com.example.couriercloudapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

   // FirebaseDatabase rootNode;
    //DatabaseReference reference;
    FirebaseFirestore mFireStore;
String userid;
    EditText namefield, passwordfield, phonefield;
    Button Signupbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        namefield = findViewById(R.id.editTextTextPersonName);
        passwordfield = findViewById(R.id.editTextTextPassword);
        phonefield = findViewById(R.id.editTextPhone2);
        Signupbutton = findViewById(R.id.signupbutton);
        mFireStore=FirebaseFirestore.getInstance();
        Signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // rootNode = FirebaseDatabase.getInstance();
                //reference = rootNode.getReference("users");

                String name = namefield.getText().toString();
                String password = passwordfield.getText().toString();
                String phonenumber = phonefield.getText().toString();

                //UserHelperClass helperClass = new UserHelperClass(name,password,phonenumber);

                //reference.child(phonenumber).setValue(helperClass);

                Map<String,String> usermap=new HashMap<>();
                usermap.put("name",name);
                usermap.put("password",password);
                usermap.put("phone",phonenumber);

                DocumentReference documentReference=mFireStore.collection("users").document(phonenumber);

                documentReference.set(usermap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Signup.this, "User Created Successfully!", Toast.LENGTH_SHORT).show();;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Signup.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });















                Intent homepage = new Intent(Signup.this, HomePage.class);
                startActivity(homepage);

            }
        });

    }
}