package com.example.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MediaPlayer mp = MediaPlayer.create(this, R.raw.original);
         mp = MediaPlayer.create(getApplicationContext(), R.raw.original);
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
