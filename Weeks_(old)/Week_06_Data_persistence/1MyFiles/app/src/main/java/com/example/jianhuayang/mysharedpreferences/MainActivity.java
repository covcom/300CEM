package com.example.jianhuayang.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhone;
    public static final String FILE_NAME = "contacts.txt";
    private File file;
    private FileOutputStream outputStream;
    private FileInputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.nameText);
        editTextPhone = (EditText) findViewById(R.id.phoneText);
        file = new File(this.getFilesDir(), FILE_NAME);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void save(View v) {
        String data = editTextName.getText().toString() + "|" + editTextPhone.getText().toString();
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(data.getBytes());
            outputStream.close();
            Toast.makeText(this, "data saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(View v) {
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        try {
            inputStream = new FileInputStream(file);
            inputStream.read(bytes);
            inputStream.close();
            String data = new String(bytes);
            editTextName.setText(data.split("\\|")[0]);
            editTextPhone.setText(data.split("\\|")[1]);
            Toast.makeText(getBaseContext(), "data loaded", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
