package com.example.jianhuayang.hellome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "HelloMeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        EditText editName = (EditText) findViewById(R.id.editText);
        TextView textDisplay = (TextView) findViewById(R.id.textViewDisplay);
        String nameToDisplay = editName.getText().toString();
        textDisplay.setText("Hello " + nameToDisplay);
        Log.d(TAG, nameToDisplay + ", this is your system log!");
    }
}
