package com.example.simplenumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int num = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView simpleNum = (TextView) findViewById(R.id.textView);
        Timer timer = new Timer();
        long delay = 0;
        long period = 1000;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                num++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (isSimpleNum(num)) {
                            simpleNum.setText(simpleNum.getText() + " " + num);
                        }
                    }
                });
            }
        },delay,period);
    }

    public static boolean isSimpleNum(int i){
        if (i<=1)
            return false;
        else if (i <=3)
            return true;
        else if (i%2==0 || i %3 ==0)
            return false;
        int n = 5;
        while (n*n <=i){
            if (i % n ==0 || i % (n+2) == 0)
                return false;
            n=n+6;
        }
        return true;
    }
}