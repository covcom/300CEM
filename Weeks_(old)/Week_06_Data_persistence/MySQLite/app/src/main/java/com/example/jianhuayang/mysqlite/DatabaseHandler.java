package com.example.jianhuayang.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jianhuayang on 01/11/15.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, "testDB", null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contactTable (colID, colName, colPhone)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("colID", contact.getId());
        values.put("colName", contact.getName());
        values.put("colPhone", contact.getPhone());

        long result = db.insert("contactTable", null, values);
        if (result > 0) {
            Log.d("dbhelper", "inserted successfully");
        } else {
            Log.d("dbhelper", "failed to insert");
        }

        db.close();
    }
}
