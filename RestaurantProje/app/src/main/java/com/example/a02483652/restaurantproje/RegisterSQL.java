package com.example.a02483652.restaurantproje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class RegisterSQL {

    static final String DATABASE_NAME = "database.db";
    String ok = "OK";
    static final int DATABASE_VERSION = 1;
    public static String passwordGir = "";
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table "+" LOGIN "+"("+" ID "+" integer primary key autoincrement,"+"NAMEREGISTER text,PASSWORDREGISTER text);";

    public static SQLiteDatabase db;

    private final Context context;

    private static SQLiteHelper databaseHelper;

    public RegisterSQL(Context _context) {
        context = _context;
        databaseHelper = new SQLiteHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public RegisterSQL open() throws SQLException {
        db = databaseHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public String insertEntry(String kullanıcıAdı, String passwordGir) {
        try {
            ContentValues newValues = new ContentValues();

            newValues.put("NAMEREGISTER", kullanıcıAdı);
            newValues.put("PASSWORDREGISTER",passwordGir );


            db = databaseHelper.getWritableDatabase();

            long result = db.insert("LOGIN", null, newValues);

            System.out.print(result);

            Toast.makeText(context, "User ınfo saved", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
            Log.e("Note", "One row entered");
        }
        return ok;
    }

    /** public int deleteEntry(String kullancıAdı) {
        String where = " USERNAME=?";
        int numberOfEntriesDeleted = db.delete("LOGIN", where, new String[]{kullancıAdı});
        Toast.makeText(context, "Number of Entrty Deleted Succesfully: " + numberOfEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOfEntriesDeleted;
    }
     */

    public String getSinlgeEntry(String kullanıcıAdı) {
        db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query("LOGIN", null, "NAMEREGISTER=?", new String[]{kullanıcıAdı}, null, null,null);

        if (cursor.getCount() < 1)
            return "NOT EXIST";
        cursor.moveToFirst();
        passwordGir = cursor.getString(cursor.getColumnIndex("PASSWORDREGISTER"));
        return passwordGir;
    }

    /**public void updateEntry(String userName, String password) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);

        String where = "USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});
    }
     */
}
