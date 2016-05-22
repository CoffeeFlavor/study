package org.seckill.exception;

/**
 * User: jennie
 * Date: 2016/5/22
 * Time: 22:50
 * 重复秒杀异常（运行期异常）
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatKillException(String message) {
        super(message);
    }
}
