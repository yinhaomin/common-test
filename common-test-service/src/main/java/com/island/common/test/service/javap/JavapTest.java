package com.island.common.test.service.javap;

public class JavapTest {

    public static void main(String[] args) {
        int a = 1, b = 1, c = 1, d = 1;
        a++;
        ++b;
        c = c++;
        d = ++d;

        System.out.println("a=" + a + ", b=" + b + ",c=" + c + ",d=" + d);
    }

}
