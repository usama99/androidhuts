package com.quick.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    //is timer start;
    private boolean running;
    Button start, pause, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.starttime);
        pause = findViewById(R.id.pausetime);
        reset = findViewById(R.id.reset);
        runtimer();
    }

    public void onStartTimer(View view) {
        running = true;
    }

    public void onPauseTimer(View view) {
        running = false;
    }

    public void onResetTimer(View view) {
        running = false;
        seconds = 0;
    }

    private void runtimer(){
        final TextView showtimer = findViewById(R.id.showtime);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = seconds/3600;
                int min = (seconds%3600)/60;
                int sec = seconds%60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hour, min, sec);
                showtimer.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
