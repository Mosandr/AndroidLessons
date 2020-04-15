package com.example.javaoop;

import android.util.Log;

public class Bike extends Transport {
    String model;
    int year;

    public Bike(){}

    public Bike(String model, int year){
        this.model = model;
        this.year = year;
    }

    public void starRide(){
        Log.i("ride", "I ride my bike!");
    }

    public void getPassenger(int weight){

        class Passenger {
            String gender;
            int weight;

            public Passenger(String gender, int weight){
                this.gender = gender;
                this.weight = weight;
            }

            String passengerHello(){
                return "Hello! Please ride me!";
            }
        }

        Passenger passenger = new Passenger("Female", weight);

        if (passenger.gender.equals("Female") && passenger.weight<65) {
            Log.i("passenger", passenger.passengerHello() + " Hello! I will ride you!");
        } else {
            Log.i("passenger", passenger.passengerHello() + " Hello! Sorry, but I can't ride you!");
        }
    }
}