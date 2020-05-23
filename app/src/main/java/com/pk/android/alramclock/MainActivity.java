package com.pk.android.alramclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button alaram, worldclock, stopwatch, timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alaram = findViewById(R.id.btn_alaram);
        worldclock = findViewById(R.id.btn_worldclock);
        timer = findViewById(R.id.btn_timer);
        stopwatch= findViewById(R.id.btn_stopwatch);

        alaram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlarmClock.class);
                startActivity(intent);

            }
        });
        worldclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WorldClock.class);
                startActivity(intent);

            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Timer.class);
                startActivity(intent);

            }
        });
        stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Stopwatch.class);
                startActivity(intent);

            }
        });
    }

}
