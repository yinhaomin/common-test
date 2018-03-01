package com.baidu.hui.common.test.biz.classloader;

public class TestClassLoaderThread extends Thread {

    @Override
    public void run() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
    }

}
