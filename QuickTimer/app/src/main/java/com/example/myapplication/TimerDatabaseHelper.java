package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimerDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "timer.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "timer_history";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_END_TIME = "end_time";

    public TimerDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DURATION + " TEXT, " +
                COLUMN_END_TIME + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
