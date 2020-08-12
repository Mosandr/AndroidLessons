package com.example.cooltimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {


    private MediaPlayer mp2;
    private SeekBar seekBar;
    private Button btn;
    private TextView textView;
    private int defaultProgress;
    private CountDownTimer myTimer;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textView);
        seekBar=findViewById(R.id.seekBar);
        btn=findViewById(R.id.btn);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mp2 = MediaPlayer.create(this,R.raw.tick_sound);

        seekBar.setMax(600);
        setIntervalFromSharedPreference(sharedPreferences);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
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
            updateTimer(defaultProgress);

        }
    }

    public void setMyTimer(int timerTimeSec){
        myTimer = new CountDownTimer(timerTimeSec*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished/1000);
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                if (sharedPreferences.getBoolean("enable_sound",true)){
                    mp2.start();
                    }
            }

            @Override
            public void onFinish() {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.bell_sound);
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String melodyName= sharedPreferences.getString("timer_melody","bell");
                if(melodyName.equals("bell")){
                    mp = MediaPlayer.create(getApplicationContext(),R.raw.bell_sound);
                } else if(melodyName.equals("alarm siren")){
                    mp = MediaPlayer.create(getApplicationContext(),R.raw.alarm_siren_sound);}
                else if(melodyName.equals("bip")){
                    mp = MediaPlayer.create(getApplicationContext(),R.raw.bip_sound);}

                if (sharedPreferences.getBoolean("enable_sound",true)){
                mp.start();}
                seekBar.setEnabled(true);
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

    private void setIntervalFromSharedPreference(SharedPreferences sharedPreferences){
        defaultProgress = Integer.valueOf(
                sharedPreferences.getString("default_interval", "30"));
        seekBar.setProgress(defaultProgress);
        updateTimer(defaultProgress);
    }

    public void updateTimer(int sec){
        textView.setText(getTimeText(sec));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("default_interval"));
        setIntervalFromSharedPreference(sharedPreferences);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }
}
