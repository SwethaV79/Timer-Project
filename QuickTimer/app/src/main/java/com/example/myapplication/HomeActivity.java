package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    // Button to open Timer screen
    public void openTimerScreen(View view) {
        Intent intent = new Intent(HomeActivity.this, TimerActivity.class);
        startActivity(intent);
    }

    // Button to open Sound Settings screen
    public void openSoundSettings(View view) {
        Intent intent = new Intent(HomeActivity.this, SoundSettingsActivity.class);
        startActivity(intent);
    }

    // Button to open Timer History screen
    public void openTimerHistory(View view) {
        Intent intent = new Intent(HomeActivity.this, TimerHistoryActivity.class);
        startActivity(intent);
    }
}
