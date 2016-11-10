package com.example.jianhuayang.mytests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String DAYS_KEY = "DAYS_KEY";
    private TextView textView;
    private EditText editText;
    private Deadline deadline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void onUpdateClick(View v) {
        deadline = new Deadline(editText.getText().toString(), this);
        textView.setText(deadline.calculate() + " days to 300CEM deadline!");
    }

    public void onSaveClick(View v) {
        deadline = new Deadline(editText.getText().toString(), this);
        deadline.save();
    }

    public void onSendClick(View v) {
        deadline = new Deadline(editText.getText().toString(), this);
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(DAYS_KEY, deadline.calculate());
        startActivity(intent);
    }
}
