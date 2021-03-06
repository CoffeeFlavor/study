package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * User: jennie
 * Date: 2016/5/19
 * Time: 15:14
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可过滤重复
     * @param seckilled
     * @param userPhone
     * @return 插入行数
     */
    int insertSuccessKilled(@Param("seckilled") long seckilled,@Param("userPhone") long userPhone);


    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") Long seckillId,@Param("userPhone") long userPhone);


}
