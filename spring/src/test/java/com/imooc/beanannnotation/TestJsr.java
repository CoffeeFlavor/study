package com.imooc.beanannnotation;

import com.imooc.base.UnitTestBase;
import com.imooc.beanannnotation.jsr.JsrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * User: jennie
 * Date: 2016/6/14
 * Time: 17:38
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestJsr extends UnitTestBase {

    public TestJsr() {
        super("classpath*:spring/spring-beanannotation.xml");
    }

    @Test
    public void test(){
        JsrService service=getBean("jsrService");
        service.save();
    }
}
