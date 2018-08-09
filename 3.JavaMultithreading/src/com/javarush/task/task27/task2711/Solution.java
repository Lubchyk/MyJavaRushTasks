package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
*/
public class Solution {
//    private final Object lock = new Object();
    private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
//        synchronized (lock) {
        isWaitingForValue = false;
            while (isWaitingForValue) {


            }

            retrieveValue();

        latch.countDown();
        latch.await();
//        }
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution().someMethod();
    }
}
