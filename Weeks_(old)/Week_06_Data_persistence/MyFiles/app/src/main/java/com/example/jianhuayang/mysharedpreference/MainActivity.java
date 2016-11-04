package com.example.jianhuayang.mysharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPhone;
    //    public static final String NAME_KEY = "NAME_KEY";
//    public static final String PHONE_KEY = "PHONE_KEY";
//    private SharedPreferences sharedPreferences;
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
//        sharedPreferences = getSharedPreferences("MySharedPreMain", Context.MODE_PRIVATE);
//
//        if (sharedPreferences.contains(NAME_KEY)) {
//            editTextName.setText(sharedPreferences.getString(NAME_KEY, ""));
//        }
//
//        if (sharedPreferences.contains(PHONE_KEY)) {
//            editTextPhone.setText(sharedPreferences.getString(PHONE_KEY, ""));
//        }
        file = new File(getFilesDir(), FILE_NAME);

    }

    public void save(View v) {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(NAME_KEY, editTextName.getText().toString());
//        editor.putString(PHONE_KEY, editTextPhone.getText().toString());
//        editor.commit();
//        Toast.makeText(v.getContext(), "data saved", Toast.LENGTH_SHORT).show();
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
