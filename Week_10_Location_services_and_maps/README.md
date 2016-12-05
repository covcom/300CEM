# Location Services and Google Maps

Most, if not all, Android devices have built-in sensors such as motion sensors to detect screen orientation and position sensors to detect your current position. [Read the official API guide for an overview of sensors available on the Android platform](https://developer.android.com/guide/topics/sensors/sensors_overview.html). Among many sensors that are available, the most widely used one is the location sensor.

## Lab 1 Location Services

There are different ways of determining an Android device's location. Two widely used APIs are the built-in Android location (android.location) and the Google Play services. The Google Play services location APIs, which are part of Google Play Services, are preferred over the Android framework location APIs (android.location) as it offers simpler interfaces and better battery usage.

In the following exercise, we’ll use the Google Play services location APIs to create an app that is capable of determining a device's location. In addition, the app can interpret the device's location in terms of latitude/longitude and turn it into a meaningful address.

### The app

Follow steps below to download the sample app from module's GitHub page and run it on your own machine.

1. Make sure Google play service is available on your system. In Android Studio, click Tools ==> Android ==> SDK Manager, this will bring up the Preference tool window Android SDK settings page. Make sure that Google Play services are installed.
    
    ![](.md_images/sdk.png)
    
2. Install the app. Download sample project called MyLocation from module's GitHub page, and open it in Android Studio. Click Build ==> Rebuild Project. In case that the system complains about Google Play services version required is different from what is installed, you'll need to delete existing dependency and replace it with the one you have.
    
    ![](.md_images/dependency.png)
    
3. Get the permission. Run the app on an AVD (not a real device, as you'll need to mock locations later), the first screen you'll see is something like below. These are really placeholders.
    
    ![](.md_images/app_1st.png)
    
    Now if you click On/Off button, it'll ask your permission to access device location. Click Allow.
    
    ![](.md_images/app_allow.png)
    
4. Simulate location changes in AVD. In the Extended controls window for AVD, in the Location tab, insert the following location for latitude and longitude respectively, 52.191064 and -1.707510, and click Send.
    
    ![](.md_images/app_mock.png)
    
5. Determine current location and display Address. If you click the Locate button in the app you'll see that the above latitude/longitude corresponds to an address in Stratford (Shakespeare birthplace). If you then decide to mock a new location and send to the AVD, the app should pick this new location automatically for you.
    
    ![](.md_images/app_locate.png)

### Source code

In following sections, some important concepts used in the demo app are explained. More importantly, the sample project is well documented. You should study the source code carefully and read comments. You should also try and change some source code to explore and see what different functions the altered software offers.

__Get the permission__

The app needs to access the device's location. There're two parts to get this done:

1. First of all, declare 'uses-permission' in manifest file, contained within the `manifest` tag
    
    ```xml
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    ```
    
2. In MainActivity.java, check if permission is granted or not. If not, request that permission. You'll only need to do this once.
    
    ```java
   if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
           PackageManager.PERMISSION_GRANTED) {
       ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
               REQUEST_LOCATION);
   }
    ```
    
    How Android system handles permission has changed. The old way is to require all permissions upon installation. And the new way is to require individual permission on first use.

__Get last known location__

The app builds the GoogleApiClient to begin with. Once it is built, the client connects to Google Play services in the background. If it connects successfully, getting the last known location is just a single line of code

```java
mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
```

Note here even though at the very beginning of this document we mentioned that the Google Play services location APIs are preferred over the Android framework location APIs, `getLastLocation()` function will, in fact, return an `android.location.Location` object.

__Receive location updates__

To receive location updates, i.e. get notified each time the device has a new location, use the following code

```java
LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
```

In the above code, `this` pass the current object as the listener by implementing the `onLocationChanged()` method.

```java
 @Override
    public void onLocationChanged(Location location) {
    //actual code
    }
```

__Turn geographic location into addresses__

To convert geographic location into an address, or the opposite, you'll need the Geocoder class from android.location.

```java
List<Address> addresses = mGeocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
```

In fact, the three classes we need from android.location are Address, Geocoder, and Location.

## Lab 2 Google Maps

The first app allows you to manipulate devices' location without touching the Google Map. However, it'll be much nicer to see how the app interacts with the user on a real map. 

### Get started

Before diving into module demo code, take a look at the [Getting Started on Google Maps Android API](https://developers.google.com/maps/documentation/android-api/start). 

![](.md_images/gm_gs.png)

In the above tutorial 'Step 4. Get a Google Maps API key', when you go to Google developer console to create a new project, the default project name is also 'My Project'. If that name annoys you, it can be changed through Google Cloud Platform page, on the right-hand-side under Project settings.

![](.md_images/project_name.png)

### The app

Download our demo project MyLocation2 and run it. (Uninstall any MyLocation apps if exists.) On the first load, the app looks like below

![](.md_images/app2_1st.png)

In AVD Extended controls window, set the initial location to be 38.6347 and -90.2941 for latitude and longitude respectively, click Send. Next, download [a sample GPX file from Geovative](http://www.geovative.com/GeoToursWebApp/DownloadFile.aspx?vq=JD2QD3JVBAUEBGEIFBQ8L7PURB92NJ&q190y1nqgB2r=Tck&y1tQ190y1nqgB2r=Tck&y1th5r4Vq=) and load it into AVD Extended controls window.

![](.md_images/ec.png)

In the app, click On/Off button, this will start/stop the GoogleApiClient. This will also enable the other buttons. Click on Map Frag, which stands for map fragment. Then click on the green triangle in AVD Extended controls window to start GPS playback. You'll see that as mock location changes, the app draws polylines joining some (not all!) of its determined locations.

![](.md_images/app2_lines.png)

### Source code 

__Add a map__

The app shows you two ways to add a map to an app: one uses a fragment, the other uses a MapView. Special attentions need to be paid when using MapView as one needs to [forward some activity lifecycle methods e.g. `onResume()`](https://developers.google.com/android/reference/com/google/android/gms/maps/MapView).

```java
//map using fragment
SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(mapFrag);
        mapFragment.getMapAsync(this);
```

```java
//map using mapview
mapView = (MapView) findViewById(R.id.mapFrag);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
```

__Sync location data using 

To synchronize location data from MainActivity to MapFragActivity, the app uses [the observer pattern](https://en.wikipedia.org/wiki/Observer_pattern). This is very similar to other OnXXListeners in the SDK.

> [Read Stack Overflow discussions on How to make listener to a custom variable](http://stackoverflow.com/questions/9879780/android-how-to-make-listener-to-a-custom-variable)

The MainActivity declares an interface, a member variable that belongs to that interface, and some actions this variable will take

```java
public interface OnCurrentLocationChangeListener {
    void onCurrentLocationChange(Location location);
}

//...

static private OnCurrentLocationChangeListener mOnCurrentLocationChangeListener;

//...

@Override
public void onLocationChanged(Location location) {
    mOnCurrentLocationChangeListener.onCurrentLocationChange(location);
}
```

Then, MapFragActivity implements that interface, and trace back the class and sets its listener

```java
public class MapFragActivity extends FragmentActivity implements MainActivity.OnCurrentLocationChangeListener {

//...

MainActivity.setOnCurrentLocationChangeListener(this);

//...

@Override
    public void onCurrentLocationChange(Location location) {
    }

```

## Lab 3 Advanced topics

### Official training on Making Your App Location-Aware

The MyLocation project roughly follows the Android official guide [Making Your App Location-Aware](https://developer.android.com/training/location/index.html). The complete source code for that project, called Basic Location Sample, is on [GitHub](https://github.com/googlesamples/android-play-location/tree/master/BasicLocationSample) too. However, that project is not quite up-to-date in a sense that how apps obtain permissions has changed. To get up-to-date on how the latest permission system works, take a look at the following:

* [Google Play Services and Runtime Permissions](https://developers.google.com/android/guides/permissions)
* [Android Guide Requesting Permissions at Run Time](https://developer.android.com/training/permissions/requesting.html)





