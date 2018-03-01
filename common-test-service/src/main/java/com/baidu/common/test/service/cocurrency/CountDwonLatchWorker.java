package com.baidu.common.test.service.cocurrency;

import java.util.concurrent.CountDownLatch;

public class CountDwonLatchWorker extends Thread {

    private String name;

    private int time;

    private CountDownLatch countDownLatch;

    public CountDwonLatchWorker(String name, int time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(name + " ended in waiting.");
        countDownLatch.countDown();
    }

}
