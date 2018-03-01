package com.baidu.common.test.service.stringbuilder;

public class StringBuilderBufferTest {

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.capacity());
//        System.out.println(sb.length());
//        sb.append("12345678901234567890");
//        System.out.println(sb.capacity());
//        System.out.println(sb.length());
//        sb.append("12345678901234567890");
//        System.out.println(sb.capacity());
//        System.out.println(sb.length());
//
//        String str = "";
//        str.concat("");
//        // System.out.println(str.charAt(0));
//        char[] data = new char[0];
//        System.out.println(data.length);
//        System.out.println(str.length());

        David d = new David();
        d.setXy(4);
        System.out.println(d.hashCode());
    }

    public void testStringBuilder() {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        sb.append("12345678901234567890");
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        sb.append("12345678901234567890");
        System.out.println(sb.capacity());
        System.out.println(sb.length());

        String str = new String("df");
    }

}
