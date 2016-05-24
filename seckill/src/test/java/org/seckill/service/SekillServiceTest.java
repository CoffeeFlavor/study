package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.Oneway;

import java.util.List;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/5/24
 * Time: 10:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SekillServiceTest {

    private final Logger logger= LoggerFactory.getLogger(Logger.class);

    @Autowired
    private SekillService sekillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list=sekillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void testGetById() throws Exception {
        long id=1000;
        Seckill seckill=sekillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id=1000;
        Exposer exposer=sekillService.exportSeckillUrl(id);
        logger.error("exposer={}",exposer.toString());
    }

    //测试
    @Test
    public void testExportSeckillLogic() throws Exception {
        long id=1000;
        Exposer exposer=sekillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone=18969295548L;
            String md5=exposer.getMd5();
            try {
                SeckillExecution execution = sekillService.executeSeckill(id,phone,md5);
                logger.error("result={}",execution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            }catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }
        }else {
            //秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }


    @Test
    public void testExecuteSeckill() throws Exception {

        long id=1000;
        long phone=15805933855L;
        String md5="e541393e6a66842574738410dbb4fd6f";
        SeckillExecution execution= null;
        try {
            execution = sekillService.executeSeckill(id,phone,md5);
            logger.error("execution={}",execution);
        } catch (RepeatKillException e) {
           logger.error(e.getMessage());
        }catch (SeckillCloseException e){
            logger.error(e.getMessage());
        }

    }
}