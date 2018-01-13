package com.example.dellp.educationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Level1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Level1_Display(this));
        //setContentView(R.layout.activity_level1);
    }
}
