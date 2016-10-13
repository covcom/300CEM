package com.example.jianhuayang.myxml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyXmlActivity";
    private EditText editTextMake;
    private EditText editTextYear;
    private EditText editTextColor;
    private EditText editTextPrice;
    private EditText editTextEngine;
    private TextView textViewBlock;
    private Vehicle vehicle;
    // the diamond syntax because the empty angle brackets have the shape of a diamond, "core java for the impatient" C. Horstmann
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private StringBuilder outputs;
    private static Double depreciation;
    private Map<String, String> mapCarMaker = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextMake = (EditText) findViewById(R.id.inputMake);
        editTextYear = (EditText) findViewById(R.id.inputYear);
        editTextColor = (EditText) findViewById(R.id.inputColor);
        editTextPrice = (EditText) findViewById(R.id.inputPrice);
        editTextEngine = (EditText) findViewById(R.id.inputEngine);
        textViewBlock = (TextView) findViewById(R.id.textBlock);
        textViewBlock.setMovementMethod(new ScrollingMovementMethod());
        depreciation = getResources().getInteger(R.integer.depreciation) / 100.00;

        String[] manufacturers = getResources().getStringArray(R.array.manufacturer_array);
        String[] descriptions = getResources().getStringArray(R.array.description_array);
        for (int i = 0; i < manufacturers.length; i++) {
            mapCarMaker.put(manufacturers[i], descriptions[i]);
        }
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

        switch (id) {
            case R.id.menu_add:
                addVehicle();
                return true;
            case R.id.menu_clear:
                return clearVehicleList();
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onButtonClick(View view) {
        String make = editTextMake.getText().toString();
        String strYear = editTextYear.getText().toString();
        int intYear = Integer.parseInt(strYear);
        String color = editTextColor.getText().toString();
        Integer price = new Integer(editTextPrice.getText().toString());
        Double engine = new Double(editTextEngine.getText().toString());

        switch (view.getId()) {
            case R.id.buttonRunPetrol:
                vehicle = new Car(make, intYear, color, price, engine);
                break;
            case R.id.buttonRunDiesel:
                vehicle = new Diesel(make, intYear, price, engine);
                break;
            default:
                vehicle = new Vehicle();
                break;
        }

        if (Vehicle.counter == 5) {
            vehicle = new Vehicle() {
                @Override
                public String getMessage() {
                    return "You have pressed 5 times, stop it!";
                }
            };
        }

        Toast.makeText(getApplicationContext(), vehicle.getMessage(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "User clicked " + Vehicle.counter + " times.");
        Log.d(TAG, "User message is \"" + vehicle + "\".");
    }

    private void addVehicle() {
        vehicleList.add(vehicle);
        resetOutputs();
    }

    private boolean clearVehicleList() {
        vehicleList.clear();
        resetOutputs();
        return true;
    }

    private void resetOutputs() {
        if (vehicleList.size() == 0) {
            outputs = new StringBuilder("Your vehicle list is currently empty.;");
        } else {
            outputs = new StringBuilder();
            for (Vehicle v : vehicleList) {
                String vehicleDescription = mapCarMaker.get(v.getMake());
                if (vehicleDescription == null) {
                    vehicleDescription = "No description available.";
                }
                outputs.append("This is vehicle No. " + (vehicleList.indexOf(v) + 1) + System.getProperty("line.separator"));
                outputs.append("Manufacturer: " + v.getMake());
                outputs.append("; Current value: " + depreciateAnything(v.getPrice()));
                outputs.append("; Effective engine size: " + depreciateAnything(v.getEngine()));
                outputs.append("; Desciption: " + vehicleDescription);
                outputs.append(System.getProperty("line.separator"));
                outputs.append(System.getProperty("line.separator"));
            }
        }
        textViewBlock.setText(outputs);
    }

    /*
    private int depreciatePrice(int price) {
        return (int) (price * depreciation);
    }

    private double depreciateEngine(double engine) {
    // below is equivalent to
    // ((double) Math.round(engine * depreciation * 100)) / 100;
    // Math.round(engine * depreciation * 100) / 100.00;
    // in operator precedence, type cast follows + and -, but proceeds * and /
        return (double) Math.round(engine * depreciation * 100) / 100;
    }
    */

    private <T extends Number> Double depreciateAnything(T originalValue) {
        Double result;
        if (originalValue instanceof Double) {
            result = Math.round(originalValue.doubleValue() * 0.8 * 100) / 100.00;
        } else {
            result = originalValue.intValue() * 0.8;
        }
        return result;
    }

    public void onClearClick(View v) {
        clearVehicleList();
    }

    /*
    // java lambda
    interface depreciatable{
        Double depreciate(Double d);
    }
    depreciatable depreciateCalculator = (Double x) -> x.doubleValue() * 0.8;
    Double output = depreciateCalculator.depreciate(v.getPrice());
    */
}
