package com.amrita.quicktimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class TimerHistoryActivity extends AppCompatActivity {

    private ListView timerHistoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_history);

        timerHistoryList = findViewById(R.id.timer_history_list);

        // Populate the timer history list
        // ...
    }
}