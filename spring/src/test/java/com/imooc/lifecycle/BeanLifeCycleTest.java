package com.imooc.lifecycle;

import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 14:37
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanLifeCycleTest extends UnitTestBase {

    public BeanLifeCycleTest() {
        super("classpath:spring/spring-lifecycle.xml");
    }

    @Test
    public void test1() {
        super.getBean("beanLifeCycle");
    }
}