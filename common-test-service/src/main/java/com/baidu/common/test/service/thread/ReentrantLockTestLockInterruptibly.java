package com.baidu.common.test.service.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 可中断锁：顾名思义，就是可以相应中断的锁。
 * </p>
 * <p>
 * Java中，synchronized就不是可中断锁，而Lock是可中断锁。
 * 如果某一线程A正在执行锁中的代码，另一线程B正在等待获取该锁，可能由于等待时间过长，线程B不想等待了，想先处理其他事情，
 * 我们可以让它中断自己或者在别的线程中中断它，这种就是可中断锁。
 * </p>
 * 如上描述，可中断锁不是锁里面的代码块被中断，而是指在获取所得等待中可中断。
 * 
 * @author yinhaomin
 *
 */
public class ReentrantLockTestLockInterruptibly {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTestLockInterruptibly test = new ReentrantLockTestLockInterruptibly();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly(); // 注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (;;) {
                if (System.currentTimeMillis() - startTime >= 5000)
                    break;
                // 插入数据
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }
}

class MyThread extends Thread {
    private ReentrantLockTestLockInterruptibly test = null;

    public MyThread(ReentrantLockTestLockInterruptibly test2) {
        this.test = test2;
    }

    @Override
    public void run() {

        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
        }
    }
}
