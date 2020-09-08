package com.example.hp.customlist;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class Humidity extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView tvText;
    private SensorEventListener sensorEventListener = new SensorEventListener(){


        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            tvText.setText(String.format(Locale.US,"%.1f ", values[0]));
            //temperatureText.setText(String.format(Locale.US, "%.1f"));

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);
        setTheme(R.style.AppTheme);



        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        tvText = findViewById(R.id.tvText);

    }

    @Override
    protected void onResume() {
        super.onResume();

        final Sensor temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        sensorManager.registerListener(sensorEventListener, temperatureSensor, SensorManager.SENSOR_DELAY_UI);


    }


    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);

    }



}

