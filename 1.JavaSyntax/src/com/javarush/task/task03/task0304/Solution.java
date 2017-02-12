package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
        double a = (double) i * 10 / 100;
        return (double) i + a;
    }

    public static void main(String[] args) {

        System.out.println(addTenPercent(9));
    }
}
