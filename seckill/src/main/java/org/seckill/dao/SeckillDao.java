package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * User: jennie
 * Date: 2016/5/19
 * Time: 15:08
 */
public interface SeckillDao {

    /**
     * 减库存
     * @param seckilled
     * @param killTime
     * @return 插入行数
     */
    int reduceNumber(@Param("seckilled") Long seckilled, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(Long seckillId);


    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}
