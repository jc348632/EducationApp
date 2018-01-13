package com.example.dellp.educationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button settingButton;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        settingButton = (Button) findViewById(R.id.settingButton);
        startButton = (Button) findViewById(R.id.startButton);


    }

    public void onClick(View view) {
        if (view == settingButton) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }
    }
}
