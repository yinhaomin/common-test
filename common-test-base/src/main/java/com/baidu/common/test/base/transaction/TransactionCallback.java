package com.baidu.common.test.base.transaction;

public interface TransactionCallback {
    /**
     * 事务的业务逻辑实现
     * 
     * @param transaction
     */
    void doInTransaction(Transaction transaction);
}
