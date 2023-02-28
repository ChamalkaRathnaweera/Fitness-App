package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Arm_tricep_dips extends AppCompatActivity {
    Button nextButton, previousButton, Start;
    TextView mTextView;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillIS;
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
        setContentView(R.layout.arm_tricep_dips);

        //Next Button
        nextButton = findViewById(R.id.nextButton);
        findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Arm_tricep_dips.this, leg.class);
                startActivity(i);
            }
        });

        // Previous Button
        previousButton = findViewById(R.id.previousButton);
        findViewById(R.id.previousButton);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Arm_tricep_dips.this, Arm_split_square.class);
                startActivity(i);
            }
        });

        //Timer

        Start = findViewById(R.id.startButton);
        mTextView = findViewById(R.id.time);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mTimerRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });
    }

    private void stopTimer(){
        countDownTimer.cancel();
        mTimerRunning = false;
        Start.setText("Start");
    }

    private void startTimer(){
        final CharSequence value1 = mTextView.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0, 2);
        String num3 = num1.substring(3, 5);

        int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        mTimeLeftInMillIS = number * 1000;

        countDownTimer = new CountDownTimer(mTimeLeftInMillIS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillIS = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newValue = Integer.valueOf(buttonValue) + 1;
                if (newValue <= 5) {
                    Intent intent = new Intent(Arm_tricep_dips.this, Arm_tricep_dips.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("Value", String.valueOf(newValue));
                    startActivity(intent);
                } else {
                    newValue = 1;
                    Intent intent = new Intent(Arm_tricep_dips.this, Arm_tricep_dips.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("Value", String.valueOf(newValue));
                    startActivity(intent);
                }
            }
        }.start();
        Start.setText("Pause");
        mTimerRunning = true;

    }
    private void updateTimer () {
        int minutes = (int) mTimeLeftInMillIS / 60000;
        int seconds = (int) mTimeLeftInMillIS % 60000 / 1000;

        String timeLeftText = "";
        if (minutes < 10)
            timeLeftText = "0";
        timeLeftText = timeLeftText + minutes + ":";
        if (seconds < 10)
            timeLeftText += "0";
        timeLeftText += seconds;
        mTextView.setText(timeLeftText);

    }
    @Override
    public void onBackPressed() {
        Arm_tricep_dips.super.onBackPressed();
        stopTimer();
        ;
        finish();
    }

}