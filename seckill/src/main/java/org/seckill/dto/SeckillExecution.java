package org.seckill.dto;

import org.seckill.entity.SuccessKilled;

/**
 * User: jennie
 * Date: 2016/5/22
 * Time: 11:30
 */
public class SeckillExecution {

    private long seckillId;

    //秒杀执行结果状态
    private int state;

    //状态表示
    private String stateInfo;

    //秒杀成功对象
    private SuccessKilled successKilled;



    public SeckillExecution(long seckillId, int state, String stateInfo, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.successKilled = successKilled;
    }
}
