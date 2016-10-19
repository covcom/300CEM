package com.example.jianhuayang.myactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MAKE = "keyMake";
    public static final String KEY_YEAR = "keyYear";
    public static final String KEY_COLOR = "keyColor";
    public static final String KEY_NOTE = "keyNote";
    private static final String TAG_LIFECYCLE = "TagLifecycle";
    private static final int REQUEST1 = 1234;

    private EditText editTextMake;
    private EditText editTextYear;
    private EditText editTextColor;
    private EditText editTextNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG_LIFECYCLE, "In the onCreate() event");

        editTextMake = (EditText) findViewById(R.id.inputMake);
        editTextYear = (EditText) findViewById(R.id.inputYear);
        editTextColor = (EditText) findViewById(R.id.inputColor);
        editTextNote = (EditText) findViewById(R.id.inputNote);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG_LIFECYCLE, "In the onStart() event");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(TAG_LIFECYCLE, "In the onRestart() event");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG_LIFECYCLE, "In the onResume() event");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG_LIFECYCLE, "In the onPause() event");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG_LIFECYCLE, "In the onStop() event");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG_LIFECYCLE, "In the onDestroy() event");
    }

    public void goEdit(View v) {
        Intent intentEdit = new Intent(this, NoteEditingActivity.class);
        startActivityForResult(intentEdit, REQUEST1);
    }

    public void goDisplay(View v) {
        Intent intentDisplay = new Intent();
        intentDisplay.setAction("com.example.jianhuayang.myactivities.ThirdActivity");
        intentDisplay.putExtra(KEY_MAKE, editTextMake.getText().toString());
        intentDisplay.putExtra(KEY_YEAR, Integer.parseInt(editTextYear.getText().toString()));
        Bundle bundle = new Bundle();
        bundle.putString(KEY_COLOR, editTextColor.getText().toString());
        bundle.putString(KEY_NOTE, editTextNote.getText().toString());
        intentDisplay.putExtras(bundle);
        startActivity(intentDisplay);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST1 && resultCode == RESULT_OK) {
            editTextNote.setText(data.getData().toString());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
