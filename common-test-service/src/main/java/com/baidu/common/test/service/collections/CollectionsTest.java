package com.baidu.common.test.service.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionsTest {

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<Integer>();
        vector.add(4);
        vector.get(0);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(1);

    }
}
