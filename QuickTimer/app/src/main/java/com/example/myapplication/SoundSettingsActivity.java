package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class SoundSettingsActivity extends AppCompatActivity {

    private ListView soundListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_settings);

        soundListView = findViewById(R.id.soundListView);

        // Populate the list of available sounds
        String[] soundOptions = {"Sound 1", "Sound 2", "Sound 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, soundOptions);
        soundListView.setAdapter(adapter);
    }
}
