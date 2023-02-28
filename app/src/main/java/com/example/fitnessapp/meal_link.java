package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class meal_link extends AppCompatActivity {

    String buttonValue;

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
        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("Value");

        int intValue = Integer.valueOf(buttonValue);

        Log.i("Message", buttonValue);

        switch (intValue) {
            case 1:
                setContentView(R.layout.monday);
                break;
            case 2:
                setContentView(R.layout.tuesday);
                break;
            case 3:
                setContentView(R.layout.wednesday);
                break;
            case 4:
                setContentView(R.layout.thursday);
                break;
            case 5:
                setContentView(R.layout.friday);
                break;
            case 6:
                setContentView(R.layout.saturday);
                break;
            case 7:
                setContentView(R.layout.sunday);
                break;

        }
    }

}








