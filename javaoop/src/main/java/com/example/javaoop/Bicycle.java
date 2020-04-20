package com.example.javaoop;

import android.util.Log;

public class Bicycle {

    String model;
    int weight;
    SterringWeel sterringWeel;

    public Bicycle(){};

    public Bicycle(String model, int weight){
        this.model=model;
        this.weight=weight;
        this.sterringWeel = new SterringWeel();
    }

    public void ride(){
        Log.i("ride", "Ride!");
    }

    public class SterringWeel {


        public void turnLeft(){
            Log.i("ride", "turn left");
        }
        public void turnRight(){
            Log.i("ride", "turn right");
        }
    }
}
