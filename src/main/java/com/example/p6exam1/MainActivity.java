package com.example.p6exam1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private int i = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        txt = (TextView) findViewById(R.id.txt);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (i == 0) {
                            startActivity(new Intent(MainActivity.this,LoginActivity.class));
                            timer.cancel();
                            finish();
                        } else {
                            txt.setText("倒计时:" + i);
                            i--;
                        }
                    }
                });
            }
        }, 1000, 1000);
    }
}