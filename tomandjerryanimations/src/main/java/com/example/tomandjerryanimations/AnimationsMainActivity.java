package com.example.tomandjerryanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class AnimationsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations_main);
    }
/*Появление без вращения*/
//    public void changeTomToJarry(View view) {
//        ImageView tomImage = findViewById(R.id.imageVtom);
//        ImageView jerryImage = findViewById(R.id.imageVjerry);
//        if (tomImage.getAlpha()==0){
//            tomImage.animate().alpha(1).setDuration(3000);
//            jerryImage.animate().alpha(0).setDuration(3000);}
//        else {
//            tomImage.animate().alpha(0).setDuration(3000);
//            jerryImage.animate().alpha(1).setDuration(3000);
//        }
//    }
    public void changeTomToJarry(View view) {
        ImageView tomImage = findViewById(R.id.imageVtom);
        ImageView jerryImage = findViewById(R.id.imageVjerry);
        if (tomImage.getAlpha()==0){
            tomImage.animate().alpha(1).rotation(tomImage.getRotation()+3600).
                    scaleX(1).scaleY(1).setDuration(3000);
            jerryImage.animate().alpha(0).rotation(jerryImage.getRotation()+3600).
                    scaleX(0).scaleY(0).setDuration(3000);}
        else {
            tomImage.animate().alpha(0).rotation(tomImage.getRotation()+3600).
                    scaleX(0).scaleY(0).setDuration(3000);
            jerryImage.animate().alpha(1).rotation(jerryImage.getRotation()+3600).
                    scaleX(1).scaleY(1).setDuration(3000);}
    }

}
