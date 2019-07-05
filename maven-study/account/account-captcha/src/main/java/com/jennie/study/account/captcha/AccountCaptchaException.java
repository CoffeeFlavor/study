package com.jennie.study.account.captcha;

/**
 * @author : jennie
 * @date: 2019/7/5
 * @Time: 21:33
 */
public class AccountCaptchaException extends RuntimeException{

    public AccountCaptchaException() {
        super();
    }

    public AccountCaptchaException(String message) {
        super(message);
    }

    public AccountCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountCaptchaException(Throwable cause) {
        super(cause);
    }

    protected AccountCaptchaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
