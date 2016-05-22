package org.seckill.exception;

/**
 * User: jennie
 * Date: 2016/5/22
 * Time: 22:53
 * 秒杀关闭异常
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
