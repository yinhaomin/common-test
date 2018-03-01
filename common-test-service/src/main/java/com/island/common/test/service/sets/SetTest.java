package com.island.common.test.service.sets;

import com.baidu.hui.common.test.biz.bo.SetVo;

public class SetTest {

    public static void main(String[] args) {
        SetVo vo = new SetVo();
        vo.getMsgSet().add("dfgd");
        System.out.println(vo);
    }

}
