package com.example.jianhuayang.mycar;

/**
 * Created by jianhuayang on 28/09/15.
 */
class Car extends Vehicle{

    private String color;
    public Car(String make, int year, String color){
        super(make, year);
        this.color = color;
        setMessage(getMessage() + " I like your shining " + color + " color.");
    }
}

class Diesel extends Vehicle implements Vehicle.Controllable {

    private String type;

    public Diesel(String make, int year){
        super(make, year);
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
