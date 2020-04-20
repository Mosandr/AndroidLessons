package com.example.javaoop;

import android.widget.SeekBar;

public abstract class Transport {

    String idNumber;
    String type;
    String model;
    Boolean isDriving;

    public Transport(){}

    public Transport(String idNumber, String type, String model){
        this.idNumber = idNumber;
        this.type = type;
        this.model = model;
    }

    abstract void repair();

    public void drive(){
        isDriving = true;
    }

    public void stop(){
        isDriving=false;
    }

    public Boolean isDriving(){
        return isDriving;
    }



}
