package com.taesu.seoul2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.taesu.seoul2.Login.LoginActivity;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;

public class Splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;

    //current location
    public static final int MY_PERMISSION_REQUEST_LOCATION = 1;
    public TextView current_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //current location
//                current_txt = (TextView) findViewById(R.id.currentlocation);
//
//                if(ContextCompat.checkSelfPermission(Splash.this,
//                        ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//                    if(ActivityCompat.shouldShowRequestPermissionRationale(Splash.this,
//                            ACCESS_COARSE_LOCATION)) {
//                        ActivityCompat.requestPermissions(Splash.this,
//                                new String[] {ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
//                    } else {
//                        ActivityCompat.requestPermissions(Splash.this,
//                                new String[] {ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
//                    }
//
//                } else {
//                    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                    try {
//
//                        MainActivity mainActivity = new MainActivity();
//
//                        //mainActivity.findAddress();
//
//                        current_txt.setText(mainActivity.findAddress(location.getLatitude(), location.getLongitude()));
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Toast.makeText(Splash.this, "Not Found", Toast.LENGTH_SHORT).show();
//                    }
//                }

                Intent intent = new Intent(Splash.this, MainActivity.class);
                //Intent intent = new Intent(Splash.this, LoginActivity.class);
                //startActivity(intent);

                //finish();
                Splash.this.startActivity(intent);
                Splash.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
