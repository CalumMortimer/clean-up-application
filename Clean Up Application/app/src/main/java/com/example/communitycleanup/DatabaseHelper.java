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
        db.execSQL("CREATE TABLE IF NOT EXISTS USERS(U_ID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME VARCHAR(15) UNIQUE NOT NULL,PASS VARBINARY(64) NOT NULL,SALTS VARBINARY(16) NOT NULL,FNAME VARCHAR(35) NOT NULL,LNAME VARCHAR(35) NOT NULL,EMAIL VARCHAR(320) UNIQUE NOT NULL,GROUP_NO INTEGER NOT NULL);");
        insertInitialData();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }

    private void insertInitialData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        byte[] myPassHash = {127,-45,126,-33,55,-69,87,-79,-75,116,-84,116,-112,-2,33,-119,89,0,83,-90,-35,103,-117,90,85,95,31,-42,-45,-97,-5,101,17,-42,126,35,-37,-69,40,-41,-85,-55,70,27,1,120,-15,-28,92,111,116,101,96,5,101,-27,-108,32,44,36,120,17,28,17};
        byte[] myPassSalt = {120,39,-53,-15,-106,-98,-87,5,-14,-68,78,-9,95,13,-23,-4};
        contentValues.put("UNAME","admin");
        contentValues.put("PASS",myPassHash);
        contentValues.put("SALTS",myPassSalt);
        contentValues.put("FNAME","John");
        contentValues.put("LNAME","Smith");
        contentValues.put("EMAIL","johnsmith@notarealemail.com");
        contentValues.put("GROUP_NO",1);
        db.insert("USERS",null,contentValues);
    }

    public boolean doesUserExist(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor myCursor = db.rawQuery("SELECT * FROM USERS WHERE USERS.UNAME = '"+username+"';",null);
        boolean result = ((myCursor!=null)&&(myCursor.getCount()!=0));
        myCursor.close();
        return result;
    }
}
