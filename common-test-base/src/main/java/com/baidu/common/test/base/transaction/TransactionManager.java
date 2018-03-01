package com.baidu.common.test.base.transaction;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;

@Log4j
@Component
public class TransactionManager {
    /**
     * 执行一个事务 1. 创建一个事务实例 2. 执行事务中的业务逻辑 3. 若执行过程中抛出异常，则启动事务回滚； 若执行顺利完成，则事务置为执行成功
     * 
     * @param transactionName
     *            事务名称
     * @param callback
     *            事务业务逻辑
     * 
     * @return
     */
    public TransactionStatus execute(String transactionName, TransactionCallback callback) {
        Preconditions.checkArgument(StringUtils.isNotBlank(transactionName));
        Preconditions.checkNotNull(callback);
        Transaction transaction = new Transaction(transactionName);
        TransactionStatus transactionStatus = transaction.getTransactionStatus();
        TransactionContext transactionContext = new TransactionContext();
        try {
            callback.doInTransaction(transaction);
            transactionStatus.setSuccess();
        } catch (Exception e) {
            log.error(transaction.getTransactionName() + " gets exception when executing, start to rollback", e);
            //transactionContext.setFailedOperation(transaction.getErrorOperation());
            transactionStatus.setRollbackOnly();
            transaction.rollback(transactionContext);
        }
        return transactionStatus;
    }
}
