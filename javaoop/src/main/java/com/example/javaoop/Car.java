package com.example.javaoop;

import android.util.Log;

public class Car  extends Transport {

    String bodyType;
    Double engineVol;
    Double consumtion;

    public Car(){}

    @Override
    void repair() {
        Log.i("repair", "Drive to service station for Cars!");
    }

    public Car(String bodyType, Double engineVol){
        this.bodyType = bodyType;
        this.engineVol = engineVol;
    }

    public Car(String bodyType, Double engineVol, Double consumtion) {
        this.bodyType = bodyType;
        this.engineVol = engineVol;
        this.consumtion = consumtion;
    }

    public void showCar(){
        Log.i("ShowCar", "My car is " + this.bodyType);
    }

    public void showCar(String color){
        Log.i("ShowCar", "My car is " + color);
    }
    public void showCar(int year){
        Log.i("ShowCar", "My car is " + year);
    }

    public Double calculateTripConsumption(Double distance){
        return consumtion*distance/100;
    }
}
