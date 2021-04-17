package com.example.couriercloudapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Login extends AppCompatActivity {


    EditText phoneNumber;
    Button continueButton;
    Button SignUp;
    private DatabaseReference mDatabase;
    FirebaseFirestore fstore;
    String mobile,usermobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        phoneNumber = findViewById(R.id.editTextPhone);

        continueButton = findViewById(R.id.contButton);

        SignUp = findViewById(R.id.signupinLogin);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        fstore = FirebaseFirestore.getInstance();
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUpscreen = new Intent(Login.this, Signup.class);
                startActivity(SignUpscreen);
                finish();
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile = phoneNumber.getText().toString();


                DocumentReference documentReference = fstore.collection("users").document(mobile);
                documentReference.addSnapshotListener(Login.this, new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                        usermobile = value.getString("phone");
                        Toast.makeText(Login.this, ""+usermobile, Toast.LENGTH_SHORT).show();

                        if(mobile.equals(usermobile)){
                            Intent homepageIntent = new Intent(Login.this, HomePage.class);
                            startActivity(homepageIntent);
                            finish();
                        }

                        else{
                            Toast.makeText(Login.this, "Mobile number doesnt exist", Toast.LENGTH_SHORT).show();
                        }

                    }
                });




            }
        });

    }


}