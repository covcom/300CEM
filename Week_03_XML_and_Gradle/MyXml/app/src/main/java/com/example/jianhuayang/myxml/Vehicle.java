package com.example.jianhuayang.myxml;

/**
 * Created by jianhuayang on 08/10/2016.
 */

public class Vehicle {
    public static int counter = 0;
    private String make;
    private int year;
    private String message;
    private int price;
    private double engine;

    // the default constructor
    public Vehicle() {
        this.make = "Volvo";
        this.year = 2012;
        this.message = "This is the default message.";
    }

    /*
    * This constructor takes four parameters
    * */
    public Vehicle(String make, int year, int price, double engine) {
        this.make = make;
        this.year = year;
        this.price = price;
        this.engine = engine;
        this.message = "Your car is a " + make + " built in " + year + ".";
        count();
    }

    /**
     * The constructor that takes only the make of the car
     *
     * @param make the make of the car
     */
    public Vehicle(String make) {
        this();
        this.make = make;
        message = "You didn't type in year value.";
        count();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    private void count() {
        this.counter++;
    }

    interface Controllable {
        void control();
    }
}
