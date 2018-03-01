package com.baidu.common.test.service.ifswitch;

public class IfSwitchTest {

    public static void main(String[] args) {
        int i = 0;
        int n = 0;
        switch (i) {
            case 101:
                n = 1;
                break;
            case 102:
                n = 2;
                break;
            case 103:
                n = 3;
                break;
            default:
                n = 0;
                break;
        }
    }

}
