package com.jennie.study.account.persist;

/**
 * @author : jennie
 * @date: 2019/7/3
 * @Time: 21:47
 */
public class AccountPersistException  extends RuntimeException{
    public AccountPersistException() {
        super();
    }

    public AccountPersistException(String message) {
        super(message);
    }

    public AccountPersistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountPersistException(Throwable cause) {
        super(cause);
    }

    protected AccountPersistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
