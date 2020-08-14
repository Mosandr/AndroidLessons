package com.example.carsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import data.DataBaseHandler;
import model.Car;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHandler dataBaseHandler = new DataBaseHandler(this);
        Log.d("CarInfo", ""+ String.valueOf(dataBaseHandler.getCarsCount()));

//        dataBaseHandler.addCar(new Car("TOYOTA", "35 000 $"));
//        dataBaseHandler.addCar(new Car("Opel", "25 000 $"));
//        dataBaseHandler.addCar(new Car("FORD", "30 000 $"));
//        dataBaseHandler.addCar(new Car("KIA", "28 000 $"));

//        Car car1 = dataBaseHandler.getCar(2);
//        dataBaseHandler.deleteCar(car1);
//
//        List<Car> carList = dataBaseHandler.getAllCars();
//        for (Car car: carList) {
//            Log.d("CarInfo", ""+ car.toString());
//
//        }

//        Car car = dataBaseHandler.getCar(1);
//        car.setName("TEsla");
//        car.setPrice("100 000 $");
//
//        dataBaseHandler.updateCar(car);
//        Log.d("CarInfo", ""+ car.toString());
    }
}
