package com.example.ryota.androidtest45;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationStart();

            this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    1000L, 50.0F, this);

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},
                    1000);
        }
    }

    private void locationStart() {
        Log.d(BuildConfig.BUILD_TYPE, "locationStart()");


        this.locationManager =
                (LocationManager) getSystemService(LOCATION_SERVICE);

        if (this.locationManager != null && this.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Log.d(BuildConfig.BUILD_TYPE, "location manager Enabled");
        } else {

            Intent settingsIntent =
                    new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
            Log.d(BuildConfig.BUILD_TYPE, "not gpsEnable, startActivity");
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);

            Log.d(BuildConfig.BUILD_TYPE, "checkSelfPermission false");
            return;
        }

        this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000L, 50.0F, this);

    }


    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1000) {
            //
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(BuildConfig.BUILD_TYPE, "checkSelfPermission true");

                locationStart();

            } else {

                Toast toast = Toast.makeText(this,
                        "これ以上なにもできません", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch (status) {
            case LocationProvider.AVAILABLE:
                Log.d(BuildConfig.BUILD_TYPE, "LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d(BuildConfig.BUILD_TYPE, "LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d(BuildConfig.BUILD_TYPE, "LocationProvider.TEMPORARILY_UNAVAILABLE");
                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.d("locationdebug", "緯度:" + location.getLatitude() + " 経度:" + location.getLongitude());
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
