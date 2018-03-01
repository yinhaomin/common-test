package com.baidu.common.test.service.cocurrency;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    private static final int THREAD_NUM = 5;

    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(THREAD_NUM, new Runnable() {

            public void run() {
                System.out.println("Inside the cb.");
            }
        });

        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(new WorkerThread(cb)).start();
        }

    }

}
