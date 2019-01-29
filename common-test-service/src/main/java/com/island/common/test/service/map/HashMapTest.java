package com.island.common.test.service.map;

import com.google.common.collect.Maps;

import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();
        for (int i = 0; i < 17; i++) {
            map.put("ASDF" + i, "ASDF" + i);
        }
    }
}
