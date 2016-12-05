package com.example.yang.mylocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/*
Different interfaces contain different abstract methods that the current class needs to override
ConnectionCallbacks==>abstract void onConnected(Bundle connectionHint); abstract void onConnectionSuspended(int cause)
OnConnectionFailedListener==>abstract void onConnectionFailed(ConnectionResult result)
LocationListener==>abstract void	onLocationChanged(Location location)
*/

//*
// TODO: retrieve activity state upon configuration change i.e. rotation, for an example see here https://developer.android.com/training/location/receive-location-updates.html#save-state
// TODO: save/retrieve object types in Bundle using putParcelable, see same URL above
// TODO: use objects that belong to class ResultReceiver as a media to send/receive messages, see
// here https://github.com/googlesamples/android-play-location/blob/master/LocationAddress/app/src/main/java/com/google/android/gms/location/sample/locationaddress/MainActivity.java and https://developer.android.com/training/location/display-address.html
// */

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public static int REQUEST_LOCATION = 1;

    // member views
    protected TextView mLatitudeText;
    protected TextView mLongitudeText;
    protected TextView mTimeText;
    protected TextView mOutput;
    protected Button mLocateButton;

    // member variables that hold location info
    protected GoogleApiClient mGoogleApiClient;
    protected Location mLastLocation;
    protected LocationRequest mLocationRequest;
    protected Geocoder mGeocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize views
        mLatitudeText = (TextView) findViewById((R.id.latitude_text));
        mLongitudeText = (TextView) findViewById((R.id.longitude_text));
        mTimeText = (TextView) findViewById((R.id.time_text));
        mLocateButton = (Button) findViewById(R.id.locate);
        mOutput = (TextView) findViewById((R.id.output));

        // below are placeholder values used when the app doesn't have the permission
        mLatitudeText.setText("Latitude not available yet");
        mLongitudeText.setText("Longitude not available yet");
        mTimeText.setText("Time not available yet");
        mOutput.setText("");

        // GoogleApiClient allows to connect to remote services, the two listeners are the first
        // two interfaces the current class implements
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocateButton.setEnabled(mGoogleApiClient.isConnected());

        // LocationReques sets how often etc the app receives location updates
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onConnected(@Nullable Bundle connectionHint) {

        // check if the current app has permission to access location of the device
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            // This ACCESS_COARSE_LOCATION corresponds to permission defined in manifest
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_LOCATION);
        } else {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (mLastLocation != null) {
                mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
                mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
                mTimeText.setText("Last known location");
            }

            // the last parameter specify the onLocationChanged listener
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    /*
    * This overriding method overrides ActivityCompat.OnRequestPermissionsResultCallback,
    * basically that is a method inherited.
    * */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_LOCATION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onConnected(null);
            }
        }
    }

    /*
    * Update UI on location change detected.
    * */
    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
        mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
        mTimeText.setText(DateFormat.getTimeInstance().format(new Date()));
    }

    /*
    * Manually start/stop GoogleApiClient connection. This is for demo purposes only. In real
    * world case you'll want to start/stop in Activity life cyle callbacks. Take a look in here
    * https://developer.android.com/training/location/retrieve-current.html
    * */
    public void onStartClicked(View v) {
        if (!mGoogleApiClient.isConnected()) {
            mGoogleApiClient.connect();
            mLocateButton.setEnabled(true);
            mOutput.setText("GoogleApiClient has started. You can see the location icon in status bar");
        } else {
            mGoogleApiClient.disconnect();
            mLocateButton.setEnabled(false);
            mOutput.setText("GoogleApiClient has stopped. Location icon in status has gone.");
        }
    }

    /*
    * Get the address from the current location, and display back in the app.
    * This is for demo purposes only. In real world case you'll want to implement this in a
    * separate thread so that it won't block your main UI thread.
    * */
    public void onLocateClicked(View v) {
        mGeocoder = new Geocoder(this);
        try {
            // Only 1 address is needed here.
            List<Address> addresses = mGeocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);

            if (addresses.size() == 1) {
                Address address = addresses.get(0);
                StringBuilder addressLines = new StringBuilder();
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    addressLines.append(address.getAddressLine(i) + "\n");
                }
                mOutput.setText(addressLines);
            } else {
                mOutput.setText("WARNING! Geocoder returned more than 1 addresses!");
            }
        } catch (Exception e) {
            mOutput.setText("WARNING! Geocoder.getFromLocation() didn't work!");
        }
    }
}
