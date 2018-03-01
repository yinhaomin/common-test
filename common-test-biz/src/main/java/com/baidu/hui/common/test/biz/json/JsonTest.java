package com.baidu.hui.common.test.biz.json;

import com.alibaba.fastjson.JSON;
import com.baidu.hui.common.test.biz.bo.TestBo;

public class JsonTest {

    public static void main(String[] args) {
        TestBo testBo = new TestBo();
        testBo.setId(1);
        testBo.setName("name");

        String alibabaJson = JSON.toJSONString(testBo);
        System.out.println(alibabaJson);
    }
}
