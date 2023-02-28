package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class profile extends AppCompatActivity {
    EditText editUserName, editHeight, editWeight,editID,editPassword;
    DatabaseManager dbManager;
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
        setContentView(R.layout.profile);
        editUserName = (EditText) findViewById(R.id.EditTextUserName);
        //editHeight = (EditText) findViewById(R.id.EditTextHeight);
        //editWeight = (EditText) findViewById(R.id.EditTextWeight);
        editID = (EditText) findViewById(R.id.EditTextUserID);
        editPassword = (EditText) findViewById(R.id.EditTextPassword);

        dbManager = new DatabaseManager(this);
        try{
            dbManager.open();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void btnInsertPressed(View v){
        dbManager.insert(editUserName.getText().toString(),editPassword.getText().toString());
    }

    public void btnSavePressed(View v) {
        Cursor cursor = dbManager.fetch();

        if (cursor.moveToFirst()) {
            do {
                String ID = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_ID));
                String user_name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_NAME));
                String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_PASSWORD));
               // String ID = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_ID));
               // String ID = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_ID));
                Log.i("DAtABASE_TAG", "I have read ID : "+ ID + "Username:" + user_name + "password:" + password);
            }
            while (cursor.moveToNext());
        }
    }
    public void btnUpdatePressed(View v){
        dbManager.update(Long.parseLong(editID.getText().toString()),editUserName.getText().toString(),editHeight.getText().toString());
    }

    public void btnDeletePressed(View v){
        dbManager.delete(Long.parseLong(editID.getText().toString()));
    }
}