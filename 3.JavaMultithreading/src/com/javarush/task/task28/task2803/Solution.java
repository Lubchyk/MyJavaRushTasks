package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom.nextInt(from, to);
    }

    public static double getRandomDouble() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom.nextDouble();    }

    public static long getRandomLongBetween0AndN(long n) {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return current.nextLong(n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getRandomLongBetween0AndN(15));
        }
    }
}
