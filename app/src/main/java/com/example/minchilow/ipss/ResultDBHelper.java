package com.example.minchilow.ipss;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ResultDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "StudentDataBase.db";
    private static final String SQL_CREATE_STUDENTS_TABLE =
            "CREATE TABLE " + ResultHistory.ResultDetail.TABLE_NAME + " (" +
                    ResultHistory.ResultDetail._ID + " INTEGER PRIMARY KEY," +
                    ResultHistory.ResultDetail.COLUMN_EMAIL_NO + " TEXT NOT NULL," +
                    ResultHistory.ResultDetail.COLUMN_RESULT + " TEXT NOT NULL," +
                    ResultHistory.ResultDetail.COLUMN_DATE + " TEXT NOT NULL" +
                    " );";


    public ResultDBHelper(Context context) {
        // create database
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // here is where you create the table
        sqLiteDatabase.execSQL(SQL_CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ResultHistory.ResultDetail.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
