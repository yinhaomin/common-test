package com.baidu.common.test.base.transaction;

public class TransactionStatus {
    public static final int INIT = 0;
    public static final int EXECUTING = 1;
    public static final int SUCCESS = 2;
    public static final int ROLLBACK_ONLY = 3;
    public static final int ROLLBACKING = 4;
    public static final int ROLLBACK_SUCCESS = 5;
    public static final int ROLLBACK_ERROR = 6;

    private int status = INIT;

    public TransactionStatus(int status) {
        this.status = status;
    }

    public void setRollbackOnly() {
        this.status = ROLLBACK_ONLY;
    }

    public void setSuccess() {
        this.status = SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
