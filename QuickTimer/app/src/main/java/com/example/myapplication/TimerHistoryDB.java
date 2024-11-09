package com.amrita.quicktimer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimerHistoryDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "timer_history.db";
    private static final int DATABASE_VERSION = 1;

    public TimerHistoryDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the timer history table
        db.execSQL("CREATE TABLE timer_history (_id INTEGER PRIMARY KEY, duration TEXT, end_time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade the database
    }

    public void addTimerHistory(String duration, String endTime) {
        // Add a new timer history entry
    }

    public Cursor getTimerHistory() {
        // Retrieve the timer history
    }
}