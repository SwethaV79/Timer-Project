package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimerActivity extends Activity {

    private EditText hoursInput, minutesInput, secondsInput;
    private TextView timerDisplay;
    private Button startButton, pauseButton, resetButton;
    private TimerService timerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        // Initialize views
        hoursInput = findViewById(R.id.hoursInput);
        minutesInput = findViewById(R.id.minutesInput);
        secondsInput = findViewById(R.id.secondsInput);
        timerDisplay = findViewById(R.id.timerDisplay);
        startButton = findViewById(R.id.startButton);
        pauseButton = findViewById(R.id.pauseButton);
        resetButton = findViewById(R.id.resetButton);

        timerService = new TimerService(this);

        // Start button click event
        startButton.setOnClickListener(v -> startTimer());

        // Pause button click event
        pauseButton.setOnClickListener(v -> pauseTimer());

        // Reset button click event
        resetButton.setOnClickListener(v -> resetTimer());
    }

    private void startTimer() {
        int hours = Integer.parseInt(hoursInput.getText().toString());
        int minutes = Integer.parseInt(minutesInput.getText().toString());
        int seconds = Integer.parseInt(secondsInput.getText().toString());

        timerService.startTimer(hours, minutes, seconds);
    }

    private void pauseTimer() {
        timerService.pauseTimer();
    }

    private void resetTimer() {
        timerService.resetTimer();
    }
}
