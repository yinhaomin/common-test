package com.island.common.test.service.nativecodes;

public class HelloWorld {

    public native void hello();

    static {
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {

        new HelloWorld().hello();
    }

}
