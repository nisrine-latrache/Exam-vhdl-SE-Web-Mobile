package com.example.hp.customlist;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Proximite extends AppCompatActivity implements SensorEventListener {

    SensorManager mSensorManager;
    Sensor mProximity;
    TextView tvValue, tvLabel;
    ProgressBar distance;
    float max;

    // When we create the app.
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_proximite);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        tvValue = (TextView) findViewById(R.id.tvValue);
        tvLabel = (TextView) findViewById(R.id.tvLabel);

        distance = (ProgressBar) findViewById(R.id.distanceBar);

        max = mProximity.getMaximumRange();
        distance.setMax((int)max);
    }

    // When we resume the app.
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    // When we pause the app.
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    // Triggers when ANY sensor has detected a change, depending on it's min/max delay.
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY){
            float val = event.values[0];
            String out =  + val + "\n";
            tvValue.setText(out);
            distance.setProgress((int)val);
        }
    }

    // Triggers when the accuracy of a sensor changes (such as GPS)
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
