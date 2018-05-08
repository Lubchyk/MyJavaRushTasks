package com.javarush.task.task22.task2212;

import java.util.Objects;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (Objects.isNull(telNumber)) return  false;
        String temp = telNumber;
        int length = temp.replaceAll("\\D", "").length();
        if (telNumber.contains("[a-aA-Z]")) return false;
        if (length == 12) {
            return telNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        else if (length == 10) {
            return telNumber.matches("^(\\d|\\(\\d{3}\\))\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        return false;
    }

    public static void main(String[] args) {

//        System.out.println(checkTelNumber(null));
//        System.out.println(checkTelNumber("+380501234567"));
//        System.out.println(checkTelNumber("+38(050)1234567"));
//        System.out.println(checkTelNumber("+38050123-45-67"));
//        System.out.println(checkTelNumber("050123-4567"));
//        System.out.println(checkTelNumber("+38)050(1234567"));
//        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
//        System.out.println(checkTelNumber("050ххх4567"));
//        System.out.println(checkTelNumber("050123456"));
//        System.out.println(checkTelNumber("(0)501234567"));
//                 - true
//                 - true
//                 - true
//         - true
//                 - false
//                 - false
//         - false
//         - false
//         - false
    }
}
