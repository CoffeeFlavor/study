package com.imooc.aop;

import com.imooc.aop.schema.advice.Fit;
import com.imooc.aop.schema.advice.biz.AspectBiz;
import com.imooc.aop.schema.advisors.service.InvokeService;
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
public class TestAOPSchemaAdvisors extends UnitTestBase {

    public TestAOPSchemaAdvisors() {
        super("classpath:spring/spring-aop-schema-advisors.xml");
    }

    @Test
    public void testSave() {
        InvokeService  service= super.getBean("invokeService");
        service.invoke();

        System.out.println();
        service.invokeException();
    }
}
