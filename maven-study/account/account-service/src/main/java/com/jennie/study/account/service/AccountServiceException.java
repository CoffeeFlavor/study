package com.jennie.study.account.service;

/**
 * @author : jennie
 * date: 2019/7/5
 * Time: 21:33
 */
public class AccountServiceException extends RuntimeException{

    public AccountServiceException() {
        super();
    }

    public AccountServiceException(String message) {
        super(message);
    }

    public AccountServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountServiceException(Throwable cause) {
        super(cause);
    }

    protected AccountServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
