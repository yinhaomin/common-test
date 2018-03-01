package com.baidu.common.test.service.stackheap;

public class StackOOMTest {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        StackOOMTest test = new StackOOMTest();
        test.stackLeakByThread();
    }
}
