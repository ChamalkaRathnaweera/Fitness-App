package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercise extends AppCompatActivity {

    Button arm,leg,abb,breast,butt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Dark Mode
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Dark);
        }
        else{
            setTheme(R.style.Theme_Light);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        //Arm
        arm = findViewById(R.id.arms);
        findViewById(R.id.arms);

        arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exercise.this,Arm_lying_tricep.class);
                startActivity(i);
            }
        });


        //Leg
        leg = findViewById(R.id.legs);
        findViewById(R.id.legs);

       leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exercise.this,leg.class);
                startActivity(i);
            }
        });


        //Abb
        abb = findViewById(R.id.Abs);
        findViewById(R.id.Abs);

        abb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exercise.this,abb.class);
                startActivity(i);
            }
        });


        //Next Button
       butt = findViewById(R.id.Butt);
        findViewById(R.id.Butt);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exercise.this,butt.class);
                startActivity(i);
            }
        });

        //Breast
        breast = findViewById(R.id.Bust);
        findViewById(R.id.Bust);

       breast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Exercise.this,Breast_chest_fly.class);
                startActivity(i);
            }
        });
    }
}