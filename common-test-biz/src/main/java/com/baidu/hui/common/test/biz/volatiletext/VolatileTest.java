package com.baidu.hui.common.test.biz.volatiletext;

public class VolatileTest {

    public volatile static int count = 0;

    public static void inc() {

        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }

        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        // 同时启动1000个线程，去进行i++计算，看看实际结果

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    VolatileTest.inc();
                }
            }).start();
        }

        Thread.sleep(10000L);
        System.out.println("运行结果:VolatileTest.count=" + VolatileTest.count);
    }
}
