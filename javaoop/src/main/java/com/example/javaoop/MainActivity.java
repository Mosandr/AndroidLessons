package com.example.javaoop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Transport bus = new Transport("AA4546KK", "Bus", "Ford");
//        bus.drive();
//        Log.i("Drive", ""+ bus.type +" "+bus.idNumber+ " Is driving: " + bus.isDriving());
//        bus.stop();
//        Log.i("Drive", ""+ bus.type +" "+bus.idNumber+ " Is driving: " + bus.isDriving());
//
//        Car car1 = new Car("SUV",2.5,13.5);
//        car1.model = "ford";
//        car1.idNumber = "AA6777AA";
//        car1.type = "Car";
//        car1.drive();
//        Log.i("Drive",car1.type +" "+car1.idNumber+" "+car1.model + " "
//                + car1.engineVol + " with Consumtion: " +car1.consumtion+ " Is driving: " + car1.isDriving());
//        Log.i("Drive", car1.type +" "+car1.idNumber +
//                " Trip consumption for 225km = " + car1.calculateTripConsumption(225D));
//
//        Taxi taxi = new Taxi(9988,4);
//        taxi.type = "Taxi"; taxi.model = "Hundai"; taxi.idNumber= "BB7777BB"; taxi.consumtion = 10D;
//        taxi.getPassenger(); taxi.getPassenger();
//        Log.i("Drive", taxi.type +" "+taxi.idNumber + "Quantity of passengers: "+ taxi.numOfPassengers +
//                " Trip consumption for 300km = " + car1.calculateTripConsumption(225D));
//
//        Car car = new Car();
//        car.bodyType = "Universal";
//        Car car2 = new Car("SUV",1.8D);
//        Car car3 = new Car("Sedan", 1.4D, 10D);
//
//        car.showCar();
//        car2.showCar("Green");
//        car3.showCar(2019);
//
//        Puma puma = new Puma();
//        puma.talk();

//        Car ford = new Car();
//        Bike suzuki = new Bike();
//        Truck maz = new Truck();
//
//        ArrayList<Transport> arrayList= new ArrayList<Transport>();
//
//        arrayList.add(ford);
//        arrayList.add(suzuki);
//        arrayList.add(maz);
//
//        Log.i("className", "Array Length is " + arrayList.size());
//
//        for (int i=0; i<arrayList.size(); i++) {
//            if (arrayList.get(i) instanceof Car){Log.i("className", ""+ i+"element is Car" ); }
//            if (arrayList.get(i) instanceof Bike){Log.i("className", ""+ i+"element is Bike" ); }
//            if (arrayList.get(i) instanceof Truck){Log.i("className", ""+ i+"element is Truck" ); }
//        }

//        Cat cat1= new Cat();
//        Cat cat2 = new Cat();
//
//        Log.i("countCats", ""+ Cat.coutCats);
//
//        Bicycle bicycle = new Bicycle("Giant",12);
//        bicycle.ride();
//        bicycle.sterringWeel.turnRight();
//        bicycle.sterringWeel.turnLeft();
//
//        Bike bike1 = new Bike("Suzuki", 2010);
//        bike1.getPassenger(55);
//        bike1.getPassenger(65);

//        Bicycle flyingBicycle = new Bicycle(){
//            @Override
//            public void ride() {
//                Log.i("ride", "Ride and Fly!");
//            }
//        };
//        flyingBicycle.ride();
//
        Person person =new Person("Dave", 25);

        person.sayHello();
        person.askHelp();
        person.sayThanks();
    }
}
