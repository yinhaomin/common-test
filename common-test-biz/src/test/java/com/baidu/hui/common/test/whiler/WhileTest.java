package com.baidu.hui.common.test.whiler;

import org.junit.Test;

public class WhileTest {

    @Test
    public void testWhile() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                if (i == 8) {
                    return;
                }
                System.out.println(i);
            }

        }
    }

}
