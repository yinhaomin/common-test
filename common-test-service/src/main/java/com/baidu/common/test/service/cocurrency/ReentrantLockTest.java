package com.baidu.common.test.service.cocurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();

        Runnable callable = new Runnable() {

            @Override
            public void run() {
                System.out.println("Start try to lock");
                lock.lock();
                System.out.println("Successfully locked");
            }

        };
        Runnable callable2 = new Runnable() {

            @Override
            public void run() {
                System.out.println("2Start try to lock");
                lock.lock();
                System.out.println("2Successfully locked");
                lock.unlock();
            }

        };

        new Thread(callable2).start();
        new Thread(callable).start();
        new Thread(callable2).start();
        //new Thread(callable).start();
        System.out.println(lock.getQueueLength());
    }

}
