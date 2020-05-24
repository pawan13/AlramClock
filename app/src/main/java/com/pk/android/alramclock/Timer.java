package com.pk.android.alramclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Timer extends AppCompatActivity {
    TextView timetext;
    EditText timeedit;
    private int seconds;
    boolean running, wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        timeedit = findViewById(R.id.edt_time);
         timetext = findViewById(R.id.txttimer);

          seconds = Integer.parseInt(timeedit.getText().toString());
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }
    @Override
    public void onSaveInstanceState(
     Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }
    public void onPause() {
        super.onPause();
        if(wasRunning){
            running = false;
        }
    }
    public void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    private void runTimer() {
        final EditText settime = timeedit;
        final TextView timeView = timetext;
        seconds = Integer.parseInt(settime.getText().toString());
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs =seconds% 60;

                String time = String.format(Locale.getDefault(),"%d:%02d:%02d", hours,minutes,secs);
                timeView.setText(time);
                if(running){
                    seconds--;
                }
                handler.postDelayed(this,1000);
            }
        });

    }

    public void onClickstart(View view) {
        timeedit.setVisibility(View.INVISIBLE);
        timetext.setVisibility(View.VISIBLE);
        running = true;

    }

    public void onclickpause(View view) {
        timeedit.setVisibility(View.INVISIBLE);
        timetext.setVisibility(View.VISIBLE);
        running = false;

    }

    public void onclickcancel(View view) {
        timeedit.setVisibility(View.VISIBLE);
        timeedit.setText("00:00:00");
        timetext.setVisibility(View.INVISIBLE);
        running = false;
    }
}
