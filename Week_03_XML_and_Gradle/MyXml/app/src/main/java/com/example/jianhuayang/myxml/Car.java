package com.example.jianhuayang.myxml;

/**
 * Created by jianhuayang on 09/10/2016.
 */

class Car extends Vehicle {
    private String color;

    public Car(String make, int year, String color, int price, double engine){
        super(make, year, price, engine);
        this.color = color;
        setMessage(getMessage() + " I like your shining " + color + " color.");
    }
}

class Diesel extends Vehicle implements Vehicle.Controllable {

    private String type;

    public Diesel(String make, int year, int price, double engine){
        super(make, year, price, engine);
        this.type = "Diesel";
    }

    @Override
    public void control() {
        setMessage(super.getMessage() + " Emission is under control.");
    }

    @Override
    public String getMessage() {
        control();
        return super.getMessage();
    }
}
