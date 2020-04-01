package com.example.javaoop;

public class Taxi extends Car{

    int serviceNumber;
    int maxNumOfPassengers;
    int numOfPassengers;

    public Taxi(){}

    public Taxi(int serviceNumber, int maxNumOfPassengers){
        this.serviceNumber = serviceNumber;
        this.maxNumOfPassengers =maxNumOfPassengers;
    }

    public Boolean getPassenger(){
        if (numOfPassengers!=maxNumOfPassengers) {
            numOfPassengers++;
            return true;
        } else return false;
    }

}
