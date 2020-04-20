package com.example.javaoop;

import android.util.Log;

public class Person implements Talkable {
    String name;
    int age;

    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public void sayHello() {
        Log.i("person", "Hello! I'm "+this.name + "!"+ " I'm " +this.age+ " years old!");
    }

    @Override
    public void askHelp() {
        Log.i("person", "Can you help me?");
    }

    @Override
    public void sayThanks() {
        Log.i("person", "Thank you! You are so kind!");
    }
}
