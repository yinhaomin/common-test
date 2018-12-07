package com.island.common.test.service.btree;

import lombok.Data;

@Data
public class BTree {

    private int numOfKey;

    private BTree parent;

    private BTree[] children;

}
