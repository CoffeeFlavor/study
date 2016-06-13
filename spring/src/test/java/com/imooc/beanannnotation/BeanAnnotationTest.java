package com.imooc.beanannnotation;

import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/6/12
 * Time: 10:11
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanAnnotationTest extends UnitTestBase {

    public BeanAnnotationTest() {
        super("classpath:spring/spring-beanannotation.xml");
    }

    @Test
    public void test() {
        BeanAnnotation bean = super.getBean("beanAnnotation");
        bean.say("This is test");
    }

    @Test
    public void testScope() {
        BeanAnnotation bean = super.getBean("beanAnnotation");
        bean.myHashCode();
        bean = super.getBean("beanAnnotation");
        bean.myHashCode();
    }
}