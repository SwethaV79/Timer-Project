package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySecond extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.text1);
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("Name")){
                String secondIntentStr = intent.getStringExtra(("Name"));
                txt.setText(secondIntentStr);
            }
        }
    }
}
