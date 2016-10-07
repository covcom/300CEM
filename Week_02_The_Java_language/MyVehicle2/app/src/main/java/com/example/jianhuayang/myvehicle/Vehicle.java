package com.example.jianhuayang.myvehicle;

/**
 * Created by jianhuayang on 25/09/15.
 * @author jianhuayang
 * @version 1.0
 */
public class Vehicle {
    private String make;
    private int year;
    private String message;
    public static int counter = 0;

    // The default constructor
    public Vehicle() {
        this.make = "Volvo";
        this.year = 2012;
        this.message = "This is the default message.";
    }

    /*
     * This constructor takes two parameters.
     */
    public Vehicle(String make, int year) {
        this.make = make;
        this.year = year;
        this.message = "Your car is a " + make + " built in " + year + ".";
        count();
    }

    /**
     * The constructor that takes only the make of the car.
     * @param make the make of your car.
     */
    public Vehicle(String make) {
        this();
        this.make = make;
        message = "You didn't type in year value.";
        count();
    }

    @Override
    public String toString() {
        return message;
    }

    public String getMessage() {
        return message;
    }

    private void count() {
        this.counter++;
    }
}
