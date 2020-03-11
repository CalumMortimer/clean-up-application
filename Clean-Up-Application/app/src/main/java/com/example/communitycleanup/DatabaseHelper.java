package com.example.communitycleanup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {



    public DatabaseHelper(Context context)
    {
        super(context,"user.db",null,1);
        SQLiteDatabase db = this.getWritableDatabase();
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS USERS(U_ID INTEGER PRIMARY KEY AUTOINCREMENT,FNAME VARCHAR(35) NOT NULL,LNAME VARCHAR(35) NOT NULL,EMAIL VARCHAR(320) UNIQUE NOT NULL,GROUP_NO INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }

    public void insert(String fname,String lname,String email,int groupno)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FNAME",fname);
        contentValues.put("LNAME",lname);
        contentValues.put("EMAIL",email);
        contentValues.put("GROUP_NO",groupno);
        db.insert("USERS",null,contentValues);
    }
}
