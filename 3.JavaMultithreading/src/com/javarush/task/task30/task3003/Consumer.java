package com.javarush.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    TransferQueue<ShareItem> queue = new LinkedTransferQueue<>();

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
            while (true) {
                ShareItem take = queue.take();
                String s = take.toString();
                System.out.format("Processing %n" + s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
