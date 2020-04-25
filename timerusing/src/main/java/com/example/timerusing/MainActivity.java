package com.example.timerusing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=findViewById(R.id.textView1);

        /**First option how to set timer*/
//        final Handler handler = new Handler();
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                TextView textView = findViewById(R.id.textView1);
//                textView.append("\nTwo seconds are passed");
//                handler.postDelayed(this, 2000);
//            }
//        };
//        handler.post(runnable);

        /** Second option how to set timer*/

        CountDownTimer myTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textView.setText(""+millisUntilFinished/1000+" seconds left");

            }

            @Override
            public void onFinish() {

                textView.setText("Finish!");
            }
        };
    }
}
