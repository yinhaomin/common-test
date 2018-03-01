package com.baidu.common.test.service.cocurrency;

import java.util.concurrent.CyclicBarrier;

public class WorkerThread implements Runnable {

    private CyclicBarrier cb;

    public WorkerThread(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println("Start to run the WorkerThread.");
        try {
            this.cb.await();
        } catch (Exception e) {
        }
        System.out.println("End to run the WorkerThread.");
    }

}
