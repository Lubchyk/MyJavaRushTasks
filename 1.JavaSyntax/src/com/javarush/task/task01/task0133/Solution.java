package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getCountSecondsPassedInCurrentHour(12345));
    }

    public static int getCountSecondsPassedInCurrentHour(int seconds) {
//        for (; true ;) {
//            if(seconds > 3600) seconds = seconds - 3600;
//            else break;
//        }
        return seconds % 3600;
    }
}