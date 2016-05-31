package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
public class SeckillServiceTest {

    private final Logger logger= LoggerFactory.getLogger(Logger.class);

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list= seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void testGetById() throws Exception {
        long id=1000;
        Seckill seckill= seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id=1000;
        Exposer exposer= seckillService.exportSeckillUrl(id);
        logger.error("exposer={}",exposer.toString());
    }

    //测试
    @Test
    public void testExportSeckillLogic() throws Exception {
        long id=1000;
        Exposer exposer= seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone=18969295548L;
            String md5=exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id,phone,md5);
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
            execution = seckillService.executeSeckill(id,phone,md5);
            logger.error("execution={}",execution);
        } catch (RepeatKillException e) {
           logger.error(e.getMessage());
        }catch (SeckillCloseException e){
            logger.error(e.getMessage());
        }

    }

    @Test
    public void  executeSeckillProcedure(){
        long seckillId=1001;
        Long phone= 16809561443L;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()){
            String md5=exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            logger.info(execution.getStateInfo());
        }
    }
}