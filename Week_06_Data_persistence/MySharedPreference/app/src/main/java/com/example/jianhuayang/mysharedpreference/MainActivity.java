package com.example.jianhuayang.mysharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPhone;
    public static final String NAME_KEY = "NAME_KEY";
    public static final String PHONE_KEY = "PHONE_KEY";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.nameText);
        editTextPhone = (EditText) findViewById(R.id.phoneText);
        sharedPreferences = getSharedPreferences("MySharedPreMain", Context.MODE_PRIVATE);

        if (sharedPreferences.contains(NAME_KEY)) {
            editTextName.setText(sharedPreferences.getString(NAME_KEY, ""));
        }

        if (sharedPreferences.contains(PHONE_KEY)) {
            editTextPhone.setText(sharedPreferences.getString(PHONE_KEY, ""));
        }
    }

    public void save(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, editTextName.getText().toString());
        editor.putString(PHONE_KEY, editTextPhone.getText().toString());
        editor.commit();
        Toast.makeText(v.getContext(), "data saved", Toast.LENGTH_SHORT).show();
    }
}
