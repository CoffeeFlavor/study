package com.imooc.bean;

import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 10:14
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanScopeTest extends UnitTestBase{

    public BeanScopeTest() {
        super("classpath*:spring/spring-scope.xml");
    }

    @Test
    public void testSay() throws Exception {
        BeanScope beanScope=super.getBean("beanScope");
        beanScope.say();
        beanScope=super.getBean("beanScope");
        beanScope.say();
    }


    @Test
    public void test2Say() throws Exception {
        BeanScope beanScope=super.getBean("beanScope");
        beanScope.say();
    }
}