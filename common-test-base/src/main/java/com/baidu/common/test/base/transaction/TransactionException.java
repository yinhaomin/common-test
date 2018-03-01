package com.baidu.common.test.base.transaction;

public class TransactionException extends RuntimeException {

    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(Throwable throwable) {
        super(throwable);
    }
}
