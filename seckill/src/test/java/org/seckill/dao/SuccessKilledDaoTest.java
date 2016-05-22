package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by CoffeeFlavor on 2016/5/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        long id = 1001L;
        long phone=18959292955L;
        int insertCount=successKilledDao.insertSuccessKilled(id,phone);
        System.out.println("insertCount"+insertCount);
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        Long seckillId=1001L;
        long phone=18959292955L;
        SuccessKilled successKilled= successKilledDao.queryByIdWithSeckill(seckillId,phone);
        System.out.println("successKilled"+successKilled);
        System.out.println(successKilled.getSeckillId());
    }
}