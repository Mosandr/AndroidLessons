package com.example.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    SeekBar voleumSeekBar;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MediaPlayer mp = MediaPlayer.create(this, R.raw.original);
         mp = MediaPlayer.create(getApplicationContext(), R.raw.original);

         audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
         int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
         Log.d("maxVol", ""+maxVol);
        voleumSeekBar = findViewById(R.id.seekBar);
        voleumSeekBar.setMax(maxVol);
        voleumSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 Log.d("progress",""+ progress);
                 audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {

             }

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {

             }
         });
    }

    public void play(View view) {
        Button b =(Button) view;
        if(!mp.isPlaying()){
            mp.start();
            b.setText("Pause");
        } else {
            mp.pause();
            b.setText("Play");
        }
    }

}
