package com.imooc.aop.aspectj;

import com.imooc.aop.aspectj.biz.MoocBiz;
import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by CoffeeFlavor on 2016/7/1.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAspectj extends UnitTestBase{

    public TestAspectj(){
        super("classpath:spring/spring-aop-aspectj.xml");
    }

    @Test
    public void test(){
        MoocBiz biz=super.getBean("moocBiz");
        biz.save("This is test");
    }
}
