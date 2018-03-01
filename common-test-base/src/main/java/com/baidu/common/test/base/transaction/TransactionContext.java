package com.baidu.common.test.base.transaction;

import lombok.Data;

@Data
public class TransactionContext {
    /**
     * 执行失败的原子操作
     */
    private TransactionOperation failedOperation;
}
