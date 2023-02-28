package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class page_two extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    BMI bmi = new BMI();
    Exercise exercise = new Exercise();
    meal meal = new meal();
    Home home = new Home();

    //FitnessFragment fitnessFragment = new FitnessFragment();

    //Beginner Beginner = new Beginner();
    //Intermediate Intermediate = new Intermediate();
    //Advanced Advanced = new Advanced();

    int[] newArray;
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

        setContentView(R.layout.activity_page_two);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

       // getSupportFragmentManager().beginTransaction().replace(R.id.container,fitnessFragment).commit();

        //BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.exercise);
        //badgeDrawable.setVisible(true);
        // badgeDrawable.setNumber(8);

        //Set path to navigation buttons
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.BMI:
                        Intent bmi = new Intent(page_two.this,BMI.class);
                        startActivity(bmi);
                       // getSupportFragmentManager().beginTransaction().replace(R.id.container,BMI).commit();
                        return true;

                    case R.id.food:
                        Intent food = new Intent(page_two.this,meal.class);
                        startActivity(food);
                        // getSupportFragmentManager().beginTransaction().replace(R.id.container,meal).commit();
                        return true;

                    case R.id.exercise:
                        Intent exe = new Intent(page_two.this,Exercise.class);
                        startActivity(exe);
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,exercise).commit();
                        return true;

                    case R.id.home:
                        Intent home = new Intent(page_two.this,Home.class);
                        startActivity(home);
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,home).commit();
                        return true;

                }
                return false;
            }

        });

    }

}