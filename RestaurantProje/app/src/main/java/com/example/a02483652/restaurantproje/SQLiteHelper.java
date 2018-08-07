package com.example.a02483652.restaurantproje;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {


    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase _database) {
        try {
            _database.execSQL(RegisterSQL.DATABASE_CREATE);
        } catch (Exception er) {
            Log.e("Error", "exception");
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase _database, int oldVersion, int newVersion) {
        Log.w("TaskDBAdapter", "Upgrading database from version " + oldVersion + "to" + newVersion + "which will destroy all old data");

        _database.execSQL(" DROP TABLE IF EXISTS " + "LOGIN");
        onCreate(_database);
    }


}
