package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws ClassNotFoundException {
            wheels = new ArrayList<>();
            String[] strings = loadWheelNamesFromDB();
            for (int i = 0; i < strings.length; i++) {
                Wheel wl = null;
                for (Wheel wheel : Wheel.values()) {
                    if (strings[i].contains(wheel.toString())) {
                        wl = Wheel.valueOf(strings[i]);
                        wheels.add(wl);
                        break;
                    }
                }
                if (wl == null) throw new ClassNotFoundException();
            }
            if (wheels.size() > 4) throw new ClassNotFoundException();
            else if (wheels.size() < 4) throw new ClassNotFoundException();
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Car car = new Car();
    }
}
