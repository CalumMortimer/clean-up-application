package com.example.communitycleanup.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventDatabase extends SQLiteOpenHelper {

    public EventDatabase(Context context)
    {
        super(context,"events.db",null,1);
        SQLiteDatabase db = this.getWritableDatabase();
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS EVENTS(E_ID INTEGER PRIMARY KEY AUTOINCREMENT,DESCRIPTION VARCHAR(320) NOT NULL,LOCATION VARCHAR(320) NOT NULL,DATE VARCHAR(10) NOT NULL UNIQUE,START VARCHAR(10) NOT NULL, FINISH VARCHAR(10) NOT NULL,FAVOURITE VARCHAR(10) NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int a,int b) {
        db.execSQL("DROP TABLE IF EXISTS EVENTS");
        onCreate(db);
    }

    public void insert(String description,String location,String date,String start,String finish,String isFavourite)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DESCRIPTION",description);
        contentValues.put("LOCATION",location);
        contentValues.put("DATE",date);
        contentValues.put("START",start);
        contentValues.put("FINISH",finish);
        contentValues.put("FAVOURITE",isFavourite);
        db.insert("EVENTS",null,contentValues);
    }

    public void populate()
    {
        insert("April Cleanup","Beach House","04/04/2020","10:00","12:00","No");
        insert("May Cleanup","North Hut","03/05/2020","10:00","12:00","No");
        insert("June Cleanup","South Hut","06/06/2020","10:00","12:00","No");
    }
}
