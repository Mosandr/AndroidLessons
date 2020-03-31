package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

MediaPlayer mp;
ImageView playIcon;
SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.original);
        playIcon = findViewById(R.id.imageViewPlay);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(mp.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mp.getCurrentPosition());
            }
        },0, 100);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mp.seekTo(progress);
                }
                if(fromUser&&progress==mp.getDuration()) {
                    playIcon.setImageResource(R.drawable.ic_play_arrow_orange);
                }
//                SeekBar do not get max value, so we set condition max*0,999
                else if(!fromUser&&progress>=(Math.round(mp.getDuration()*0.999))){
                    playIcon.setImageResource(R.drawable.ic_play_arrow_orange);
                }
                Log.d("max", ""+mp.getDuration());
                Log.d("current",""+ seekBar.getProgress() );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void playPause(View view) {
        if (mp.isPlaying()) {
            mp.pause();
            playIcon.setImageResource(R.drawable.ic_play_arrow_orange);

        } else if (seekBar.getProgress() == mp.getDuration()) {
            mp.start();
            playIcon.setImageResource(R.drawable.ic_pause_orange_24dp);
            seekBar.setProgress(0);
            mp.seekTo(0);
        } else{
            mp.start();
            playIcon.setImageResource(R.drawable.ic_pause_orange_24dp);
        }

    }

    public void previous(View view) {
        seekBar.setProgress(0);
        mp.seekTo(0);

    }

    public void next(View view) {
        seekBar.setProgress(mp.getDuration());
        mp.seekTo(mp.getDuration());
        playIcon.setImageResource(R.drawable.ic_play_arrow_orange);
    }
}
