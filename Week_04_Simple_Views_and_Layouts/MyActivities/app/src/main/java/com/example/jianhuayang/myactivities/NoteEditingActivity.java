package com.example.jianhuayang.myactivities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NoteEditingActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editing);
        editText = (EditText) findViewById(R.id.inputNote);
    }

    public void onDoneClick(View v) {
        Intent intent = new Intent();
        Uri uri = Uri.parse(editText.getText().toString());
        intent.setData(uri);
        setResult(RESULT_OK, intent);
        finish();
    }

}
