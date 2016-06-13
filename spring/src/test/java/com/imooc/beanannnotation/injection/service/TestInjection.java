package com.imooc.beanannnotation.injection.service;

import com.imooc.base.UnitTestBase;
import com.imooc.beanannnotation.multibean.BeanInvoker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/6/12
 * Time: 11:15
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase{

    public TestInjection() {
        super("classpath:spring/spring-beanannotation.xml");
    }

    @Test
    public void testAutowired(){
        InjectionService service=super.getBean("injectionServiceImpl");
        service.save("This is test");
    }

    @Test
    public void testMultiBean(){
        BeanInvoker invoker=super.getBean("beanInvoker");
        invoker.say();
    }

}