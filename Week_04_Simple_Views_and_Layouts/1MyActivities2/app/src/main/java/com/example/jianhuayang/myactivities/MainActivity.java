package com.example.jianhuayang.myactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String KEY_MAKE = "keyMake";
    public static final String KEY_Fuel = "keyFuel";
    public static final String KEY_YEAR = "keyYear";
    public static final String KEY_COLOR = "keyColor";
    public static final String KEY_NEW = "keyNew";
    public static final String KEY_RIGHT_HAND = "keyRightHand";
    public static final String KEY_NOTE = "keyNote";
    private static final String TAG_LIFECYCLE = "TagLifecycle";
    private static final int REQUEST1 = 1234;
    private static final int REQUEST2 = 5678;

    private Spinner spinnerMaker;
    private Switch switchFuel;
    private EditText editTextYear;
    private RadioGroup radioGroupColor;
    private CheckBox checkBoxNew;
    private CheckBox checkBoxRightHand;
    private Button buttonImage;
    private EditText editTextNote;

    private String[] carMaker;
    private String make;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG_LIFECYCLE, "In the onCreate() event");

        spinnerMaker = (Spinner) findViewById(R.id.spinnerMake);
        switchFuel = (Switch) findViewById(R.id.switchFuel);
        editTextYear = (EditText) findViewById(R.id.inputYear);
        radioGroupColor = (RadioGroup) findViewById(R.id.radioColor);
        checkBoxNew = (CheckBox) findViewById(R.id.isNew);
        checkBoxRightHand = (CheckBox) findViewById(R.id.isRightHand);
        buttonImage = (Button) findViewById(R.id.buttonImage);
        editTextNote = (EditText) findViewById(R.id.inputNote);
        carMaker = getResources().getStringArray(R.array.car_maker);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.car_maker, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaker.setAdapter(adapter);
        spinnerMaker.setOnItemSelectedListener(this);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        make = carMaker[pos];
    }

    public void onNothingSelected(AdapterView<?> parent) {
        make = "No maker selected";
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

        if (requestCode == REQUEST2 && resultCode == RESULT_OK) {
            buttonImage.setText("");
            buttonImage.setBackgroundResource(data.getIntExtra(DownloadActivity.KEY_DRAWABLE, R.mipmap.ic_launcher));
        }
    }

    public void goDisplay(View v) {
        Intent aIntent = new Intent();
        aIntent.setAction("com.example.jianhuayang.myactivities.ThirdActivity");
//        Intent aIntent = new Intent(this, ThirdActivity.class);
        aIntent.putExtra(KEY_MAKE, make);
        aIntent.putExtra(KEY_Fuel, switchFuel.isChecked());
        aIntent.putExtra(KEY_YEAR, Integer.parseInt(editTextYear.getText().toString()));
        Bundle aBundle = new Bundle();
        String color = ((RadioButton) findViewById(radioGroupColor.getCheckedRadioButtonId())).getText().toString();
        aBundle.putString(KEY_COLOR, color);
        aBundle.putBoolean(KEY_NEW, checkBoxNew.isChecked());
        aBundle.putBoolean(KEY_RIGHT_HAND, checkBoxRightHand.isChecked());
        aBundle.putString(KEY_NOTE, editTextNote.getText().toString());
        aIntent.putExtras(aBundle);
        startActivity(aIntent);
    }

    public void goDownload(View v) {
        Intent aIntent = new Intent(this, DownloadActivity.class);
        startActivityForResult(aIntent, REQUEST2);
    }
}
