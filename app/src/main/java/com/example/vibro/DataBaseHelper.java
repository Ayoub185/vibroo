package com.example.vibro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE users ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT,"
                + "email TEXT,"
                + "password TEXT"
                + ")";
        db.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // implement database upgrade logic here
    }

    public void addUser(String name, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("password", password);
        db.insert("users", null, values);
    }

    public boolean authenticateUser(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"_id"};
        String selection = "email = ? AND password = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }
}