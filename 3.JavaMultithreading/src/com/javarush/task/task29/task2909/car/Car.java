package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    protected static final int MAX_TRUCK_SPEED = 80;
    protected static final int MAX_CABRIOLET_SPEED = 90;
    protected static final int MAX_SEDAN_SPEED = 120;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

//    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;
    private int type;

    protected Car(int type, int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        this.type = type;
    }
    public Car (int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {

        if (type == 1) return new Sedan(numberOfPassengers);
        else if (type == 0) return new Truck(numberOfPassengers);
        else if (type == 2) return new Cabriolet(numberOfPassengers);
        else return null;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters > 0) fuel += numberOfLiters;
        else throw new Exception();
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0 ? true : false;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        if (date.after(summerStart) && date.before(summerEnd)) return true;
        else return false;
    }
    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }


    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date, SummerStart, SummerEnd)) {
           return getSummerConsumption(length);
        } else {
            return getWinterConsumption(length);
        }
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred()) return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public void setType(int type) {
        this.type = type;
    }
}