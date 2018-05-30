package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    private String string;

    @Override
    public void run() {
        System.out.println(thread.getName());

        while (!thread.isInterrupted()) {
            try {
                Thread.sleep(100);
                System.out.println(thread.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    @Override
    public void start(String threadName) {
        string = threadName;
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
