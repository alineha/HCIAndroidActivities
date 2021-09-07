package com.example.activity1ex3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private EditText xEdit,yEdit,zEdit;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xEdit = findViewById(R.id.xEditText);
        yEdit = findViewById(R.id.yEditText);
        zEdit = findViewById(R.id.zEditText);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accelerometer != null)
        {
            sensorManager.registerListener(MainActivity.this, accelerometer,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            if(sensor.event.values[0] > 10 || event.values[1] > 10 || event.values[2] > 10)
                startActivity(new Intent(this, SecondaryActivity.class));

            xEdit.setText(Float.toString(event.values[0]));
            yEdit.setText(Float.toString(event.values[1]));
            zEdit.setText(Float.toString(event.values[2]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener( this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}