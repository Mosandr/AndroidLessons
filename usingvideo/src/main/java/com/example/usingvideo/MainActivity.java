package com.example.usingvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Add Android permission INTERNET to manifest file
        * <uses-permission android:name="android.permission.INTERNET"/>
        * and atribut android:usesCleartextTraffic="true"
        * */

        VideoView videoView =findViewById(R.id.videoView);
//        String pac = getPackageName();
//        Log.d ("pacName", pac);
//        videoView.setVideoPath("android.resource://"+"com.example.usingvideo"+"/"+R.raw.original);
//        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.original);
        String pathUri = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        Uri uri = Uri.parse(pathUri);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
