package com.javarush.task.task30.task3002;

import java.math.BigInteger;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62

    }

    public static String convertToDecimalSystem(String s) {
        String substring = s.substring(0, 2);
        switch (substring) {
            case "0x" :
                return String.valueOf(Integer.parseInt(s.substring(2), 16));
            case "0b" :
                return String.valueOf(Integer.parseInt(s.substring(2), 2));
            default:
                if (substring.substring(0, 1).equals("0"))
                    return String.valueOf(Integer.parseInt(s.substring(1), 8));
                    else return s;
        }
    }
}
