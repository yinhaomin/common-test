package com.baidu.common.test.base.transaction;

public interface TransactionOperation {

    /**
     * 操作名
     * 
     * @return
     */
    String getName();

    /**
     * 正向逻辑
     */
    Object execute();

    /**
     * 逆向逻辑（回滚时调用）
     * 
     * @param transactionContext
     */
    void rollback(TransactionContext transactionContext);

}
