package com.javarush.task.task25.task2506;

 class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        setDaemon(true);
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State state = thread.getState();
        System.out.println(state);
        do {
            if (state != thread.getState()) {
                state = thread.getState();
                System.out.println(state);
            }
        } while (state != State.TERMINATED);
    }
}