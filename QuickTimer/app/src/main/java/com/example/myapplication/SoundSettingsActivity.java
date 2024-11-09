package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SoundSettingsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_settings);
    }

    // Function to play preview of sound
    public void previewSound(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        int soundResId = R.raw.sound1; // Default sound
        switch (view.getId()) {
            case R.id.sound2_button:
                soundResId = R.raw.sound2;
                break;
            case R.id.sound3_button:
                soundResId = R.raw.sound3;
                break;
        }
        mediaPlayer = MediaPlayer.create(this, soundResId);
        mediaPlayer.start();
    }
}
