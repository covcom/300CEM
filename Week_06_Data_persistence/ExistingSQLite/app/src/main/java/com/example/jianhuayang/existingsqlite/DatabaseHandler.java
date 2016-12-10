package com.example.jianhuayang.existingsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jianhuayang on 10/12/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    private Context context;

    public DatabaseHandler(Context context) {
        super(context, MainActivity.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String getAll() {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM contacts", null);
        StringBuilder out = new StringBuilder();

        // http://stackoverflow.com/questions/10723770/whats-the-best-way-to-iterate-an-android
        // -cursor
        try {
            while (cursor.moveToNext()) {
                out.append(cursor.getString(0));
                out.append(cursor.getString(1));
                out.append(cursor.getString(2));
                out.append(cursor.getString(3));
                out.append("\n");
            }
        } finally {
            cursor.close();
        }

        return out.toString();
    }


}
