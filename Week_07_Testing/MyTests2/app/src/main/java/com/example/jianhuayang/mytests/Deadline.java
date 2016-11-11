package com.example.jianhuayang.mytests;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jianhuayang on 09/11/2016.
 */

public class Deadline {
    private Date date;
    private Context context;
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    private static final String DATE_KEY = "dateKey";

    public Deadline(String date, Context context) {
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.context = context;
    }

    public Deadline(String date) {
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int calculate() {
        Date submission;
        try {
            submission = dateFormat.parse("13/12/16");
            return (int) ((submission.getTime() - date.getTime() )/ (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean save() {
        SharedPreferences sharedPreferences = ((Activity)context).getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DATE_KEY, dateFormat.format(date));
        return editor.commit();
    }
}
