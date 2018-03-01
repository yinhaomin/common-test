package com.baidu.common.test.base.transaction;

import java.util.Stack;

import lombok.extern.log4j.Log4j;

/**
 * 应用层事务 Created by cheng.dai on 15/5/20.
 */
@Log4j
public class Transaction {
    /**
     * 事务名称
     */
    private String name;
    /**
     * 事务状态
     */
    private TransactionStatus transactionStatus;
    /**
     * 原子操作栈，只有执行成功的才会加入到该栈中
     */
    private Stack<TransactionOperation> operationStack;
    /**
     * 执行出错/异常的原子操作
     */
    private TransactionOperation errorOperation;

    public Transaction(String name) {
        this.name = name;
        this.transactionStatus = new TransactionStatus(TransactionStatus.INIT);
        this.operationStack = new Stack<TransactionOperation>();
    }

    /**
     * 事务执行原子操作
     * 
     * @param transactionOperation
     */
    public Object execute(TransactionOperation transactionOperation) {
        if (this.transactionStatus.getStatus() == TransactionStatus.ROLLBACK_ONLY) {
            throw new TransactionException(getTransactionName()
                    + " has been set rollback-only, transaction starts to" + " rollback");
        }
        if (this.transactionStatus.getStatus() == TransactionStatus.INIT) {
            this.transactionStatus.setStatus(TransactionStatus.EXECUTING);
        }
        try {
            Object executeResult = transactionOperation.execute();
            this.operationStack.push(transactionOperation);
            return executeResult;
        } catch (Exception e) {
            this.errorOperation = transactionOperation;
            throw new TransactionException(e);
        }
    }

    /**
     * 事务执行回滚 倒序执行操作栈中的Operation 执行过程中如遇到某个Operation回滚失败，记日志，不影响其他Operation的回滚执行
     * 
     * @param transactionContext
     */
    public void rollback(TransactionContext transactionContext) {
        int status = this.getTransactionStatus().getStatus();
        if (status != TransactionStatus.ROLLBACK_ONLY) {
            throw new TransactionException(getTransactionName() + " cannot rollback:status=" + status);
        }
        if (this.operationStack.empty()) {
            this.transactionStatus.setStatus(TransactionStatus.ROLLBACK_SUCCESS);
            return;
        }
        this.transactionStatus.setStatus(TransactionStatus.ROLLBACKING);
        for (TransactionOperation transactionOperation : this.operationStack) {
            rollbackOperation(transactionOperation, this.transactionStatus, transactionContext);
        }
        if (this.transactionStatus.getStatus() == TransactionStatus.ROLLBACKING) {
            this.transactionStatus.setStatus(TransactionStatus.ROLLBACK_SUCCESS);
        }
    }

    private void rollbackOperation(TransactionOperation transactionOperation, TransactionStatus transactionStatus,
            TransactionContext transactionContext) {
        try {
            transactionOperation.rollback(transactionContext);
        } catch (Exception e) {
            transactionStatus.setStatus(TransactionStatus.ROLLBACK_ERROR);
            log.error(String.format(getTransactionName() + " rollback operation[%s] error", transactionOperation
                    .getName()), e);
        }
    }

    public String getTransactionName() {
        return String.format("Transaction[%s]", this.name);
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public TransactionOperation getErrorOperation() {
        return errorOperation;
    }
}
