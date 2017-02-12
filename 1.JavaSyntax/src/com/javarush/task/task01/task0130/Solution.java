package com.javarush.task.task01.task0130;

/* 
Наш первый конвертер!
TC = (TF – 32) * 5/9
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertCelsiumToFahrenheit(40));
    }

    public static double convertCelsiumToFahrenheit(int celsium) {
        double a = (double) celsium * 9.0/5.0 + 32.0;
        return a;
    }
}