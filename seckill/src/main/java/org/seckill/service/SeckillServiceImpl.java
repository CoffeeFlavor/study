package org.seckill.service;

import org.seckill.dao.Cache.RedisDao;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * User: jennie
 * Date: 2016/5/23
 * Time: 8:58
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger= LoggerFactory.getLogger(SeckillServiceImpl.class);

    //注入service 依赖
    @Autowired//@Resource,@Inject
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    //md5盐值字符串，用于混淆MD5
    private final String slat="ajjdkafsjkafjkdfkjsoewpop32";

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        //优化点：缓存优化,超时的基础上维护一致性
        //1:访问redis
        Seckill seckill=redisDao.getSeckill(seckillId);
        if (seckill==null){
            //2：访问数据库
             seckill=seckillDao.queryById(seckillId);
            if (seckill==null) {
                return new Exposer(false,seckillId);
            }
            //3：放入redis
            redisDao.putSeckill(seckill);
        }
        Date startTime=seckill.getStartTime();
        Date endTIme=seckill.getEndTime();
        Date nowTime=new Date();
        if (nowTime.getTime()<startTime.getTime()
                ||nowTime.getTime()>endTIme.getTime()) {
            return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTIme.getTime());
        }
        //转化特定字符串的过程，不可逆
        String md5=getMD5(seckillId);
        return new Exposer(true,md5,seckillId);
    }

    private String getMD5(long seckillId){
        String base=seckillId+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    /**
     *使用注解控制事务方法的有点：
     * 1：开发团队达成一致约定，明确标注事务方法的编程方法
     * 2：保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者玻璃到事务方法外部
     * 3：不是所有的方法都需要事务。如只有一条修改操作,只读操作
     */
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5==null||!md5.equals(getMD5(seckillId))){
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑,减库存+记录购买行为
        Date nowTime=new Date();
        try {
            int updateCount=seckillDao.reduceNumber(seckillId,nowTime);
            if (updateCount<=0){
                //没有更新到记录
                throw new SeckillCloseException("seckill is closed");
            }else {
                //记录购买行为
                int insertCount=successKilledDao.insertSuccessKilled(seckillId,userPhone);
                if (insertCount<=0){
                    //重复秒杀
                    throw new RepeatKillException("seckill repeated");
                }else {
                    //秒杀成功
                    SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(seckillId,userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS,successKilled);
                }
            }
        }catch (SeckillCloseException e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new SeckillException("seckill inner error :"+e.getMessage());
        }
    }
}
