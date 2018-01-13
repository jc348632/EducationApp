package com.example.dellp.educationapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button settingButton;
    Button startButton;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        settingButton = (Button) findViewById(R.id.settingButton);
        startButton = (Button) findViewById(R.id.startButton);


    }

    public void onClick(View view) {
        if (view == startButton){
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
        }
        if (view == settingButton) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }
    }
}
