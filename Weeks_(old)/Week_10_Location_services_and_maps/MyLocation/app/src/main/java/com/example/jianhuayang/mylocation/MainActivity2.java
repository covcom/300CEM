package com.example.jianhuayang.mylocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;


public class MainActivity2 extends ActionBarActivity implements GoogleApiClient.ConnectionCallbacks {
    //    private LocationManager locationManager;
    private Location currentLocation;
    private TextView locationText;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationText = (TextView) findViewById(R.id.textView1);
        buildGoogleApiClient();
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
    public void onResume() {
        super.onResume();
//        currentLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateDisplay();
//        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mListener);
    }

    @Override
    public void onPause() {
        super.onPause();
//        locationManager.removeUpdates(mListener);
    }

    private void updateDisplay() {
        if (currentLocation == null) {
            locationText.setText("Determining your location...");
        } else {
            locationText.setText(
                    String.format("Your location:\n%.2f, %.2f", currentLocation.getLatitude(),
                            currentLocation.getLongitude()));
        }
    }

    //    private LocationListener mListener = new LocationListener() {
//        @Override
//        public void onLocationChanged(Location location) {
//            currentLocation = location;
//            updateDisplay();
//        }
//        @Override
//        public void onProviderDisabled(String provider) {
//        }
//        @Override
//        public void onProviderEnabled(String provider) {
//        }
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//        }
//    };
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        currentLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        updateDisplay();
    }
    @Override
    public void onConnectionSuspended(int cause) {
        mGoogleApiClient.connect();
    }
    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }
}



