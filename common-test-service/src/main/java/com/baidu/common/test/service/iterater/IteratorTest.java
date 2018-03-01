package com.baidu.common.test.service.iterater;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class IteratorTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("df");
        list.add("");
        list.remove(0);
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            iterator.remove();
        }

    }

}
