package com.example.jianhuayang.myactivities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class NoteEditingActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editing);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        editText = (EditText) findViewById(R.id.inputNote);
    }

    public void onDoneClick(View v) {
        Intent aIntent = new Intent();
        Uri aUri = Uri.parse(editText.getText().toString());
        aIntent.setData(aUri);
        setResult(RESULT_OK, aIntent);
        finish();
    }

}
