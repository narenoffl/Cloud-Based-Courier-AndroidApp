package com.example.couriercloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signUpButton;
        Button loginButton;

        signUpButton = findViewById(R.id.signup);
        loginButton = findViewById(R.id.login);

signUpButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent signup = new Intent(MainActivity.this, Signup.class);
        startActivity(signup);
    }

});

loginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent login = new Intent(MainActivity.this, Login.class);
        startActivity(login);
    }
});
    }
}