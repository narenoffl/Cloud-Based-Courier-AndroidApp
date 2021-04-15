package com.example.couriercloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText phoneNumber;
        Button continueButton;
        Button SignUp;

        phoneNumber = findViewById(R.id.editTextPhone);
        continueButton = findViewById(R.id.contButton);
        SignUp = findViewById(R.id.signupinLogin);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUpscreen = new Intent(Login.this, Signup.class);
                startActivity(SignUpscreen);
                finish();
            }
        });
    }
}