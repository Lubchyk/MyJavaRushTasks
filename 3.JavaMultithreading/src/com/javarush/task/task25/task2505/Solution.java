package com.javarush.task.task25.task2505;

/* 
Без дураков
1. Создай private class MyUncaughtExceptionHandler, который на перехват исключения должен подождать половину секунды,
а затем вывести на экран secretKey, имя трэда и сообщение возникшего исключения.
Используй String.format(...).

Пример:
super secret key, Thread-0, it's an example

2. Разберись в последовательности выполняемого кода и обеспечь логирование возникновения исключения в п.1.
3. Метод main в тестировании не участвует.
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public class MyThread extends Thread {
        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
           // setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }




        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.currentThread().sleep(500);
                    String format = String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage());
                    System.out.println(format);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        }
    }




}

