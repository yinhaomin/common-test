package com.island.common.test.service.equals;

import java.util.Map;

import com.baidu.common.test.service.stringbuilder.David;
import com.google.common.collect.Maps;
import com.island.common.test.service.stringbuilder.David;

public class EqualsHashCodeTest {

    public static void main(String[] args) {
        Map<David, Integer> dMap = Maps.newHashMap();
        dMap.put(new David(), 1);
    }

}
