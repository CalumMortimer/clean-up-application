package com.example.communitycleanup;

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
        db.execSQL("CREATE TABLE IF NOT EXISTS EVENTS(E_ID INTEGER PRIMARY KEY AUTOINCREMENT,DESCRIPTION VARCHAR(320) NOT NULL,LOCATION VARCHAR(320) NOT NULL,START DATETIME NOT NULL,FINISH DATETIME NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int a,int b) {
        db.execSQL("DROP TABLE IF EXISTS EVENTS");
        onCreate(db);
    }

    public void insert(String description,String location,String start,String finish)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DESCRIPTION",description);
        contentValues.put("LOCATION",location);
        contentValues.put("START",start);
        contentValues.put("FINISH",finish);
        db.insert("EVENTS",null,contentValues);
    }
}
