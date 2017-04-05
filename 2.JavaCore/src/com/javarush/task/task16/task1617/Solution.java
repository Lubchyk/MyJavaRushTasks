package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 4;
    public static boolean a = true;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        if (countSeconds >= 4) {
            Thread.sleep(3500);
            clock.interrupt();
            a = false;

        }
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            while (countSeconds != 0) {
                System.out.print(countSeconds-- + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.print("Прервано!");
                }

            }
            if (a) System.out.print("Марш!");
        }
    }
}
