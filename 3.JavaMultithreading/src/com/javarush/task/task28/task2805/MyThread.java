package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread  extends Thread {
   private static AtomicInteger atomicInteger = new AtomicInteger();
    public MyThread() {
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }

    public void setPriority() {
        int threadGroupPriority = 10;
        ThreadGroup threadGroup = this.getThreadGroup();
        if (threadGroup != null) threadGroupPriority = threadGroup.getMaxPriority();
        int priority = atomicInteger.incrementAndGet();
        if (priority > 10) {
            priority = 1;
            atomicInteger.set(1);
        }
        else if (priority > threadGroupPriority) {
            priority = threadGroupPriority;
        }
        this.setPriority(priority);
    }

}
