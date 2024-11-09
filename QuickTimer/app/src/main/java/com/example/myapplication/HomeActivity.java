package com.example.quicktimer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;

public class HomeActivity extends AppCompatActivity {

    private TextView timerDisplay;
    private EditText hoursInput, minutesInput, secondsInput;
    private Button startButton, pauseButton, resetButton;
    private int secondsLeft;
    private boolean isRunning = false;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize UI components
        timerDisplay = findViewById(R.id.timerDisplay);
        hoursInput = findViewById(R.id.hoursInput);
        minutesInput = findViewById(R.id.minutesInput);
        secondsInput = findViewById(R.id.secondsInput);
        startButton = findViewById(R.id.startButton);
        pauseButton = findViewById(R.id.pauseButton);
        resetButton = findViewById(R.id.resetButton);

        // Initialize media player for notification sound
        mediaPlayer = MediaPlayer.create(this, R.raw.timer_end_sound); // Set default sound

        startButton.setOnClickListener(v -> startTimer());
        pauseButton.setOnClickListener(v -> pauseTimer());
        resetButton.setOnClickListener(v -> resetTimer());
    }

    private void startTimer() {
        if (!isRunning) {
            int hours = Integer.parseInt(hoursInput.getText().toString());
            int minutes = Integer.parseInt(minutesInput.getText().toString());
            int seconds = Integer.parseInt(secondsInput.getText().toString());

            secondsLeft = (hours * 3600) + (minutes * 60) + seconds;
            new Thread(new TimerRunnable()).start();
            isRunning = true;
        }
    }

    private void pauseTimer() {
        isRunning = false;
    }

    private void resetTimer() {
        isRunning = false;
        secondsLeft = 0;
        updateDisplay();
    }

    private void updateDisplay() {
        int hours = secondsLeft / 3600;
        int minutes = (secondsLeft % 3600) / 60;
        int seconds = secondsLeft % 60;
        timerDisplay.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    private class TimerRunnable implements Runnable {
        @Override
        public void run() {
            while (isRunning && secondsLeft > 0) {
                try {
                    Thread.sleep(1000);
                    secondsLeft--;
                    runOnUiThread(HomeActivity.this::updateDisplay);

                    if (secondsLeft == 0) {
                        // Play sound when timer ends
                        mediaPlayer.start();
                        runOnUiThread(() -> {
                            // Display message when time's up
                            timerDisplay.setText("Time's up!");
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
