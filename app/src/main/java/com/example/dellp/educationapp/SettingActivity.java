package com.example.dellp.educationapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class SettingActivity extends AppCompatActivity {

    Button buttonOn;
    Button buttonOff;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        buttonOff = (Button) findViewById(R.id.buttonOff);
        buttonOn = (Button) findViewById(R.id.buttonOn);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void onClick(View view){
        if (view == buttonOff){
            preferences.edit().clear().putString("audio","off").apply();
            Toast.makeText(this,"Audio OFF",Toast.LENGTH_SHORT).show();
            finish();
        }
        if (view == buttonOn){
            preferences.edit().clear().putString("audio","on").apply();
            Toast.makeText(this,"Audio ON",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
