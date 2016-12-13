package com.example.jianhuayang.mysqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText idText;
    private EditText nameText;
    private EditText phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText = (EditText) findViewById(R.id.IDText);
        nameText = (EditText) findViewById(R.id.nameText);
        phoneText = (EditText) findViewById(R.id.phoneText);

    }

    public void save(View v){
        int anID = Integer.parseInt(idText.getText().toString());
        String aName = nameText.getText().toString();
        String aPhone = phoneText.getText().toString();
        DatabaseHandler db = new DatabaseHandler(this);
        db.addContact(new Contact(anID, aName, aPhone));
    }
}
