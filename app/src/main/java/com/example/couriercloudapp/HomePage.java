package com.example.couriercloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button scheduled_delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        scheduled_delivery = findViewById(R.id.buttonScheduled);
        scheduled_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scheduledDelView = new Intent(HomePage.this, Schedule.class);
                startActivity(scheduledDelView);
            }
        });


    }
}