package com.imooc.ioc.interfaces;

import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/6/7
 * Time: 15:45
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class OneInterfaceTest extends UnitTestBase {

    public OneInterfaceTest() {
        super("classpath*:spring/spring-ioc.xml");
    }

    @Test
    public void testHello() throws Exception {
        OneInterface oneInterface=super.getBean("oneInterface");
        System.out.println(oneInterface.hello("我的输入参数"));
    }
}