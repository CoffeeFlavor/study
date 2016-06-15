package com.imooc.aop;

import com.imooc.aop.schema.advice.biz.AspectBiz;
import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * User: jennie
 * Date: 2016/6/15
 * Time: 11:37
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAOPSchemaAdvice extends UnitTestBase {

    public TestAOPSchemaAdvice(){
        super("classpath:spring/spring-aop-schema-advice.xml");
    }

    @Test
    public void testBiz(){
        AspectBiz biz=super.getBean("aspectBiz");
        biz.biz();
    }

    @Test
    public void testInit(){
        AspectBiz biz=super.getBean("aspectBiz");
        biz.init("moocSevice",3);
    }
}
