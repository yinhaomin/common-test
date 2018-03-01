package com.baidu.common.test.service.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTestLock {

    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLockTestLock test = new ReentrantLockTestLock();

        Thread t1 = new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            };
        };
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            };
        };
        t2.start();

        t1.join();
        t2.join();
        System.out.print("The array is: " + arrayList);

    }

    public void insert(Thread thread) {
        // Lock lock = new ReentrantLock(); // 注意这个地方
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }
}
