package com.example.cooltimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    MediaPlayer mp2;
    SeekBar seekBar;
    Button btn;
    TextView textView;
    int defaultProgress =30;
    CountDownTimer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textView);
        seekBar=findViewById(R.id.seekBar);
        btn=findViewById(R.id.btn);
        mp = MediaPlayer.create(this,R.raw.bellsound);
        mp2 = MediaPlayer.create(this,R.raw.tick_sound);

        seekBar.setMax(600);
        seekBar.setProgress(defaultProgress);
        textView.setText(getTimeText(defaultProgress));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(getTimeText(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void onStartClick(View view) {
        if(btn.getText().equals("START")){
            btn.setText("STOP");
            setMyTimer(seekBar.getProgress());
            myTimer.start();
            seekBar.setEnabled(false);

        } else {
            btn.setText("START");
            seekBar.setEnabled(true);
            myTimer.cancel();
            seekBar.setProgress(defaultProgress);
            textView.setText(getTimeText(defaultProgress));

        }
    }

    public void setMyTimer(int timerTimeSec){
        myTimer = new CountDownTimer(timerTimeSec*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(getTimeText((int) millisUntilFinished/1000));
                mp2.start();
            }

            @Override
            public void onFinish() {
                mp.start();
                seekBar.setProgress(defaultProgress);
                btn.setText("START");
            }
        };
    }

    public String getTimeText(int seconds){
        String timeText ="";
        if(seconds/60<10){
        timeText=timeText+"0"+seconds/60+":";}
        else{timeText=timeText+seconds/60+":";}
        if (seconds%60<10) {
            timeText=timeText + "0" + seconds%60;
        } else {timeText=timeText + seconds%60;}
        return timeText;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.timer_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if (id==R.id.timer_settings){
            Intent openSettings = new Intent(this, SettingsActivity.class);
            startActivity(openSettings);
            return  true;
        } else if (id==R.id.timer_about){
            Intent openAbout = new Intent(this, AboutActivity.class);
            startActivity(openAbout);
            return  true;}
        return super.onOptionsItemSelected(item);
    }
}
