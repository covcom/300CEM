package com.example.yang.mylocation;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

import static com.example.yang.mylocation.R.id.mapFrag;

public class MapFragActivity extends FragmentActivity implements OnMapReadyCallback, MainActivity.OnCurrentLocationChangeListener {

    private GoogleMap mMap;
    private Location mLocation;
    private LatLng mLatLng;
    private boolean mIsFirstLine;
    private Polyline mPolyline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_frag);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(mapFrag);
        mapFragment.getMapAsync(this);
        MainActivity.setOnCurrentLocationChangeListener(this);
        mIsFirstLine = true;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        UiSettings mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mLocation = MainActivity.mLastLocation;
        mLatLng = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
        mMap.addMarker(new MarkerOptions().position(mLatLng).title("You started here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 15));

    }

    //    http://stackoverflow.com/questions/9879780/android-how-to-make-listener-to-a-custom-variable
//    observer pattern
    /*
    retrieve state
    save parcel
    send listner
     */
    @Override
    public void onCurrentLocationChange(Location location) {
        mLocation = location;
        LatLng latLng = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());

        if (mIsFirstLine) {
            PolylineOptions polylineOptions = new PolylineOptions()
                    .add(mLatLng)
                    .add(latLng);
            mPolyline = mMap.addPolyline(polylineOptions);
            mIsFirstLine = false;
        }

        mLatLng = latLng;
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 18), 2000, null);

        List<LatLng> points = mPolyline.getPoints();
        points.add(mLatLng);
        mPolyline.setPoints(points);
    }

}
