package com.island.common.test.service.map;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.collections.map.MultiKeyMap;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MapTest {

	public void main(String[] args) {

		Map<Long, Long> map = Maps.newHashMap();
		map.get("1");

		List<String> lst = Lists.newArrayList();
		lst.add(" ");

	}

	@Test
	public void testMultiKeyMap() {
		// 初始化类
		MultiKeyMap multiKeyMap = MultiKeyMap.decorate(new LinkedMap());
		multiKeyMap.put(1, 1, 2, "112");
		multiKeyMap.put(1, 1, 3, "113");
		multiKeyMap.put(1, 2, 1, "121");
		multiKeyMap.put(1, 2, 2, "122");
		multiKeyMap.put(1, 3, 1, "131");
		MultiKeyMap map = (MultiKeyMap) multiKeyMap.get(1);
		System.out.println(map);

		// 查找一个值:由1，1，2这3个key可以获得唯一的value值
		String value = (String) multiKeyMap.get(1, 1, 2);
		System.out.println("value is : " + value);// value is : 112
		String value3 = (String) multiKeyMap.get(2, 1, 1);
		System.out.println("value3 is : " + value3);// value3 is : null
		String value2 = (String) multiKeyMap.get(1, 2, 1);
		System.out.println("value2 is " + value2);// value2 is 121
		Object object1 = multiKeyMap.get(1);
		System.out.println("object1 is : " + object1);// object1 is : null
		Object object2 = multiKeyMap.get(1, 2);
		System.out.println("object2 is : " + object2);// object2 is : null
	}

}
