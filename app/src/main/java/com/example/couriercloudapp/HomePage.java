package com.example.couriercloudapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    Button scheduled_delivery;
    Button quick_delivery;
    Button gift_delivery;
    Button log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        scheduled_delivery = findViewById(R.id.buttonScheduled);
        quick_delivery = findViewById(R.id.buttonQuickDelivery);
        log_out = findViewById(R.id.buttonLogOut);

        quick_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quickDelView = new Intent(HomePage.this,QuickDelivery.class);
                startActivity(quickDelView);
            }
        });


        scheduled_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scheduledDelView = new Intent(HomePage.this, Schedule.class);
                startActivity(scheduledDelView);
            }
        });

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainPage = new Intent(HomePage.this, MainActivity.class);
                startActivity(mainPage);
                finish();
            }
        });


    }
}