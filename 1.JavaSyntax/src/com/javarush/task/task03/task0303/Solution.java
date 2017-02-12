package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(10, 27.5));
        System.out.println(convertEurToUsd(5, 27.5));
    }

    public static double convertEurToUsd(int eur, double course) {
       return  eur * course;
    }
}
