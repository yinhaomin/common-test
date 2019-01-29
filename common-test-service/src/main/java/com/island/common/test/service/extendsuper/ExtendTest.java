package com.island.common.test.service.extendsuper;

import java.util.ArrayList;
import java.util.List;

public class ExtendTest {

    public static void main(String[] args) {
        // public final class Integer extends Number
        Number num = new Integer(1);
        List<Number> list = new ArrayList<>();
        list.add(new Integer(3));
        //ArrayList<Number> list2 = new ArrayList<Integer>(); //type mismatch

        List<? extends Number> list3 = new ArrayList<Number>();
        // list3.add(new Integer(1)); //error
    }
}
