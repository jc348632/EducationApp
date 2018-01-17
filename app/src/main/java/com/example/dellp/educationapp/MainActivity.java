package com.example.dellp.educationapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.prefs.PreferenceChangeEvent;

public class MainActivity extends AppCompatActivity {
    Button settingButton;
    Button startButton;
    MediaPlayer audio;
    SharedPreferences preferences;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
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

    @Override
    protected void onStop() {
        super.onStop();
        audio.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        audio.stop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        audio = MediaPlayer.create(this,R.raw.bg);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.getString("audio","on");
        audio.start();

    }
}
