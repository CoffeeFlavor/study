package com.imooc.autowiring;

import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 16:44
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AutoWiringTest extends UnitTestBase {

    public AutoWiringTest() {
        super("classpath:spring/spring-autowiring.xml");
    }

    @Test
    public void testSay(){
        AutoWiringService service=super.getBean("autoWiringService");
        service.say("this is test");
    }

}