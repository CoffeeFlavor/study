package com.imooc.aware;

import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 16:05
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class MoocApplicationContextTest extends UnitTestBase {

    public MoocApplicationContextTest() {
        super("classpath:spring/spring-aware.xml");
    }

//    @Test
//    public void testMoocApplicationContext() {
//        System.out.println("testMoocApplicationContext:" + super.getBean("moocApplicationContext").hashCode());
//    }

    @Test
    public void testMoocBeanName() {
        System.out.println("testMoocApplicationContext:" + super.getBean("moocBeanName").hashCode());
    }
}