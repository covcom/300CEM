package com.example.jianhuayang.existingsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//some code from http://icetea09.com/blog/2014/01/22/android-use-existing-sqlite-database-in-android-app/
public class MainActivity extends AppCompatActivity {
    public static String DB_NAME = "students.sqlite3";
    private String dbPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbPath = this.getDatabasePath(DB_NAME).getPath();
        try {
            createDataBase();
        } catch (Exception e) {

        }

    }


    /***
     * Copy database from source code assets to device
     *
     * @throws IOException
     */
    public void copyDataBase() throws IOException {
        try {
            InputStream myInput = this.getAssets().open(DB_NAME);
            OutputStream myOutput = new FileOutputStream(dbPath);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception e) {
            Log.e("tle99 - copyDatabase", e.getMessage());
        }

    }

    /***
     * Check if the database doesn't exist on device, create new one
     *
     * @throws IOException
     */
    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();

        if (dbExist) {

        } else {
            try {
                copyDataBase();
            } catch (IOException e) {
                Log.e("tle99 - create", e.getMessage());
            }
        }
    }

    // ---------------------------------------------
    // PRIVATE METHODS
    // ---------------------------------------------

    /***
     * Check if the database is exist on device or not
     *
     * @return
     */
    private boolean checkDataBase() {
        SQLiteDatabase tempDB = null;
        try {
            tempDB = SQLiteDatabase.openDatabase(dbPath, null,
                    SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            Log.e("tle99 - check", e.getMessage());
        }
        if (tempDB != null)
            tempDB.close();
        return tempDB != null ? true : false;
    }

    public void onClick(View v) {
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        Log.d("xxx", databaseHandler.getAll());
    }
}
