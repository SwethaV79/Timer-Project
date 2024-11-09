package com.example.quicktimer;

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

        Button sound1Button = findViewById(R.id.sound1Button);
        Button sound2Button = findViewById(R.id.sound2Button);
        Button sound3Button = findViewById(R.id.sound3Button);

        sound1Button.setOnClickListener(v -> playSound(R.raw.sound1));
        sound2Button.setOnClickListener(v -> playSound(R.raw.sound2));
        sound3Button.setOnClickListener(v -> playSound(R.raw.sound3));
    }

    private void playSound(int soundId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, soundId);
        mediaPlayer.start();
    }
}
