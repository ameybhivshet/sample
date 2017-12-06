package com.example.dell.ab;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Dell on 11/30/2017.
 */


public class SQLitehelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =5 ;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";
    final String TABLE_NAME = "SCORE";
    final String COLUMN_ID = "ID";
    final String COLUMN_FIRST_NAME = "OVER_DATA";

Context context;
    public SQLitehelper(Context context) {


        super(context, DATABASE_NAME, null, DATABASE_VERSION);
     //   Toast.makeText(context, "Constructor called", Toast.LENGTH_SHORT).show();
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



       //sqLiteDatabase.execSQL("create table  SCORE( ID INTEGER PRIMARY KEY AUTOINCREMENT, OVER_DATA  VARCHAR);");
        try {
          sqLiteDatabase.execSQL("create table  SCORE( ID INTEGER PRIMARY KEY AUTOINCREMENT, OVER_DATA  TEXT);");

           //sqLiteDatabase.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + "VARCHAR);");
            Toast.makeText(context, "table created", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        try {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            Toast.makeText(context, "table created upgrade", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
    }
        onCreate(sqLiteDatabase);

    }



}

