package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String> strings = new ArrayList<>();
        strings.add(e.toString());
        Throwable cause = null;
        for ( ; ; ) {
           try {
               if (cause == null) cause = e.getCause();
               else cause = cause.getCause();
              String s = cause.toString();
              strings.add(s);
           } catch (Exception g) {
               break;
           }
        }
        for (int i = strings.size() - 1; i >= 0 ; i--) {
            System.out.println(strings.get(i));
        }
    }
    public static void main(String[] args) throws Exception {

        Thread.currentThread().setUncaughtExceptionHandler(new Solution());
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
    }
}
