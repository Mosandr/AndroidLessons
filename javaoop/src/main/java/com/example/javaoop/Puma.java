package com.example.javaoop;

import android.util.Log;

public class Puma {

    private String pumaHelloText;
    String name;
    int age;

    public Puma(){
        this.name = "Puma";
        this.age = 3;
        this.pumaHelloText = "I'm a cool cat!";
    }

    private String createPumaTalkText(){
        return "My name is " + this.name + " I'm " + this.age + " " + this.pumaHelloText;
    }

    public void talk(){
        Log.i("talk", createPumaTalkText());
    }
}
