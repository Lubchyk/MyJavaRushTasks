package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String a = String.valueOf(number);
        char[] v = a.toCharArray();
        int s = 0;
        for (int i = 0; i < v.length; i++) {
            s = s + Character.getNumericValue(v[i]);
        }
        return s;
    }
}