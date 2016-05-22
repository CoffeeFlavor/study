package org.seckill.exception;

/**
 * User: jennie
 * Date: 2016/5/22
 * Time: 22:54
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
