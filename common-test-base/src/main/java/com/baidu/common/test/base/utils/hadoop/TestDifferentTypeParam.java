package com.baidu.common.test.base.utils.hadoop;

public class TestDifferentTypeParam {

    public static void main(String[] args) {
        int intvale = 127;
        Byte bytevalue = (byte) 127;
        Long longvalue = 127L;
        System.out.println(intvale == bytevalue);
        System.out.println(bytevalue);
        System.out.println(intvale == longvalue);
    }

}
