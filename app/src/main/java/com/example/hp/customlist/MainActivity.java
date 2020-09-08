package com.example.hp.customlist;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.os.Bundle;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] labels = { "Accelerometer",  "Humidity","Light","Magnet", "Pressure", "Temperature", "Proximity"};
        final int[] imageIDs =

                {R.drawable.accelerometer, R.drawable.humidity, R.drawable.light, R.drawable.gyroscope, R.drawable.barometer, R.drawable.temperature, R.drawable.proximity};

        MenuGridAdapter menuGridAdapter = new MenuGridAdapter(MainActivity.this, labels, imageIDs);

        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(menuGridAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String currentItem = labels[i];

                switch(currentItem){
                    case "Accelerometer":
                        startActivity(new Intent(MainActivity.this, Accelerometer.class));
                        break;

                    case "Humidity":
                        startActivity(new Intent(MainActivity.this, Humidity.class));
                        break;
                    case "Light":
                        startActivity(new Intent(MainActivity.this, Light.class));
                        break;
                    case "Magnet":
                        startActivity(new Intent(MainActivity.this, Magnet.class));
                        break;

                    case "Pressure":
                        startActivity(new Intent(MainActivity.this, Pressure.class));
                        break;
                    case "Temperature":
                        startActivity(new Intent(MainActivity.this, Temperature.class));
                        break;
                    case "Proximity":
                        startActivity(new Intent(MainActivity.this, Proximite.class));
                        break;

                }
            }
        });
    }
}
