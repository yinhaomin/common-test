package com.baidu.hui.common.test.biz.bo;

import java.util.Set;

import com.google.common.collect.Sets;

import lombok.Data;

@Data
public class SetVo {
    
    private Set<String> msgSet = Sets.newHashSet();

}
