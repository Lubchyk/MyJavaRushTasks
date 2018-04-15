package com.javarush.task.task22.task2202;

/* 
Найти подстроку
"- лучший сервис обучения"
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            String[] split = string.split(" ");
            String s = split[1] + " " + split[2] + " " + split[3] + " " + split[4];
            return s;
        } catch (Exception e) {
            throw new TooShortStringException();
        }




    }

    public static class TooShortStringException extends RuntimeException {
    }
}
