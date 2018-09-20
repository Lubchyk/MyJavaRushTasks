package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

//    public static String recursion(int a, int b) {
//        if (a > b) {
//            return a + " " + recursion(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + " " + recursion(a + 1, b);
//        }
//    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
//        System.out.println(recursion(numberA, numberB));
//        System.out.println(recursion(numberB, numberA));
        getAllNumbersBetween(numberA, numberB);
        getAllNumbersBetween(numberB, numberA);
    }

    public static String getAllNumbersBetween(int a, int b) {
        if (a < b) {
            for (int i = a; i <= b; i++) {
                if (i == b) {
                    System.out.print(i);
                    break;
                }
                else System.out.print(i + " ");
            }
            System.out.println();
        } else if (b < a) {
            for (int i = a; i >= b; i--) {
                if (i == b) {
                    System.out.print(i);
                    break;
                } else System.out.print(i + " ");
            }
            System.out.println();
        }
        else if (a == b) {
            System.out.println(Integer.toString(a));
        }
        return "";
    }
}