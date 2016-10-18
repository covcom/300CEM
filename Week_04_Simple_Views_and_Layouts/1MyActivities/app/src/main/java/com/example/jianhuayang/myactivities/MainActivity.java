package com.example.jianhuayang.myactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_LIFECYCLE = "TagLifecycle";
    public static final String KEY_MAKE = "keyMake";
    public static final String KEY_YEAR = "keyYear";
    public static final String KEY_COLOR = "keyColor";
    public static final String KEY_NOTE = "keyNote";
    private static final int REQUEST1 = 1234;

    private EditText editTextMake;
    private EditText editTextYear;
    private EditText editTextColor;
    private EditText editTextNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextMake = (EditText) findViewById(R.id.inputMake);
        editTextYear = (EditText) findViewById(R.id.inputYear);
        editTextColor = (EditText) findViewById(R.id.inputColor);
        editTextNote = (EditText) findViewById(R.id.inputNote);

        Log.d(TAG_LIFECYCLE, "In the onCreate() event");
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

    public void goEdit(View arg0) {
        Intent aIntent = new Intent(this, NoteEditingActivity.class);
        startActivityForResult(aIntent, REQUEST1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST1 && resultCode == RESULT_OK) {
            editTextNote.setText(data.getData().toString());
        }
    }

    public void goDisplay(View v) {
        Intent aIntent = new Intent();
        aIntent.setAction("com.example.jianhuayang.myactivities.ThirdActivity");
//        Intent aIntent = new Intent(this, ThirdActivity.class);
        aIntent.putExtra(KEY_MAKE, editTextMake.getText().toString());
        aIntent.putExtra(KEY_YEAR, Integer.parseInt(editTextYear.getText().toString()));
        Bundle aBundle = new Bundle();
        aBundle.putString(KEY_COLOR, editTextColor.getText().toString());
        aBundle.putString(KEY_NOTE, editTextNote.getText().toString());
        aIntent.putExtras(aBundle);
        startActivity(aIntent);
    }
}
