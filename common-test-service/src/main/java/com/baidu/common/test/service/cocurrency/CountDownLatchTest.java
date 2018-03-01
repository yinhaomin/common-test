package com.baidu.common.test.service.cocurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new CountDwonLatchWorker("zhangsan", 1000, countDownLatch).run();
        new CountDwonLatchWorker("lisi", 3000, countDownLatch).run();
        countDownLatch.await();
        System.out.println("all work done at " + sdf.format(new Date()));
    }

}
