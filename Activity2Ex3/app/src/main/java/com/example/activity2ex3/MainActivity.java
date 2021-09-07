package com.example.activity2ex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button locationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationButton = (Button) findViewById(R.id.myLocationButton);
        ActivityCompat.requestPermissions(MainActivity.this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!=null)
                {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: "+lat + "LONG: " +
                            longi, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}