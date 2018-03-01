package com.baidu.common.test.service.hook;

public class ShutdownHookTest {

    private static final void shutdownCallback() {
        System.out.println("Shutdown callback is invoked.");
    }

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                shutdownCallback();
            }

        });
        Thread.sleep(10000);
    }

}
