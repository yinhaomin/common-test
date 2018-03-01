package com.baidu.common.test.service.list;

import com.baidu.hui.common.test.biz.bo.TestBo;
import com.baidu.hui.common.test.biz.bo.TestBo2;

public class BoFieldNullTest {

    public void main(String[] args) {
        TestBo testBo = new TestBo();
        TestBo2 testBo2 = new TestBo2();
        testBo2.setTags(testBo.getTags());
    }

}
