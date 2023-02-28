package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Advanced extends Fragment {
    private Button exercise,meal ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.advanced, container, false);

        Button exercise = (Button) view.findViewById(R.id.Buttonexercise);
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Exercise.class);
                startActivity(intent);
            }
        });
        //

        Button meal = (Button) view.findViewById(R.id.Buttonrecipe);
        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),meal.class);
                startActivity(intent);
            }
        });
        return view;

    }

}