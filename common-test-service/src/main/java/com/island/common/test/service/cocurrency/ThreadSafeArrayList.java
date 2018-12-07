package com.island.common.test.service.cocurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.log4j.Log4j;

@Log4j
public class ThreadSafeArrayList<E> {

    private Lock lock = new ReentrantLock();

    private List<E> list = new ArrayList<E>();

    private static int i = 0;

    public void add(E e) {
        lock.lock();
        try {
            i++;
            list.add(e);
            System.out.println("Adding element by thread" + Thread.currentThread().getName());
        } catch (Exception ex) {
            log.error(ex);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final ThreadSafeArrayList<String> lockExample = new ThreadSafeArrayList<String>();

        Runnable syncRunnable = new Runnable() {
            @Override
            public void run() {
                while (i < 6) {
                    lockExample.add(String.valueOf(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable lockingRunnable = new Runnable() {
            @Override
            public void run() {
                while (i < 6) {
                    lockExample.add(String.valueOf(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread1 = new Thread(syncRunnable, "syncRunnable");
        Thread thread2 = new Thread(lockingRunnable, "lockingRunnable");
        thread1.start();
        thread2.start();
    }

}
