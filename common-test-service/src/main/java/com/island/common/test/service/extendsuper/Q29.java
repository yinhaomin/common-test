package com.island.common.test.service.extendsuper;

import java.util.ArrayList;

public class Q29 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("a");
        al.add("b");
        // accept(al);
    }

    public static void accept(ArrayList<Object> al) {
        for (Object o : al)
            System.out.println(o);
    }

}