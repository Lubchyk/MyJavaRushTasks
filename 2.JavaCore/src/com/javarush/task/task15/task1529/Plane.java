package com.javarush.task.task15.task1529;

/**
 * Created by mlv on 20.03.2017.
 */
public class Plane implements Flyable{
    static int passengers;

    Plane(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public void fly() {

    }
}
