package com.imooc.aop;

import com.imooc.aop.api.BizLogic;
import com.imooc.aop.schema.advice.Fit;
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
public class TestAOPAPI extends UnitTestBase {

    public TestAOPAPI() {
        super("classpath:spring/spring-aop-api.xml");
    }

    @Test
    public void testSave() {
        BizLogic logic = super.getBean("bizLogicImpl");
        logic.save();
    }
}
