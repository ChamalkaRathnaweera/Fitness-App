package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class BMI extends AppCompatActivity {
    EditText height, weight;
    ImageView male, female;
    LinearLayout malelayout, femalelayout;
    Button button,nextButton;
    TextView result, condition;

    float h = 0, w = 0, bmi = 0, hm = 0;
    String user = "0";
    String res;


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
        setContentView(R.layout.bmi);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        malelayout = findViewById(R.id.malelayout);
        femalelayout = findViewById(R.id.femalelayout);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        condition = findViewById(R.id.condition);

        //gender
        malelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setColorFilter(getResources().getColor(R.color.black));
                female.setColorFilter(getResources().getColor(R.color.black));
                user = "Male";
            }
        });

        femalelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setColorFilter(getResources().getColor(R.color.black));
                male.setColorFilter(getResources().getColor(R.color.black));
                user = "Female";
            }
        });

        //Next Button
        nextButton = findViewById(R.id.nextButton);
        findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BMI.this,page_two.class);
                startActivity(i);
            }
        });

        //button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = height.getText().toString();
                String str2 = weight.getText().toString();
                if (user.equals("0")) {
                    Toast.makeText(BMI.this, "Please Enter Your Gender", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(str1)) {
                    height.setError("Enter Height");
                    height.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(str2)) {
                    weight.setError("Enter Weight");
                    weight.requestFocus();
                    return;
                } else {
                    cal();
                }
            }
        });

    }

    //cal function
    private void cal() {
        h = Float.parseFloat(height.getText().toString());
        w = Float.parseFloat(weight.getText().toString());

        float hm;
        hm = h/100;
        bmi =(w/(hm*hm));

        result.setText(Float.toString(bmi));
        if (bmi >= 30) {
            res = "Obeseweight. Let's do some exercises.";
            condition.setText(res);
        }
        if (bmi >= 25) {
            res= "Overweight. Let's do some exercises.";
            condition.setText(res);
        }
        if (bmi >= 18.5) {
            res = "Congratulations! You're in range. To Keep in Shape, Let's do some exercises.";
            condition.setText(res);
        } else {
            res = "Underweight. Let's follow a proper meal plan";
            condition.setText(res);
        }
    }

}