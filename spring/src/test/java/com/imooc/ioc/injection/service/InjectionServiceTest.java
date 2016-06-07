package com.imooc.ioc.injection.service;

import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.omg.CORBA.UnionMember;
import org.springframework.stereotype.Service;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/6/7
 * Time: 17:21
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class InjectionServiceTest extends UnitTestBase{

    public InjectionServiceTest() {
        super("classpath*:spring/spring-inject.xml");
    }

    @Test
    public void testSave() throws Exception {
        InjectionService service=super.getBean("injectionService");
        service.save("这是要保存的数据");
    }

    @Test
    public void testCons() throws Exception {
        InjectionService service=super.getBean("injectionService");
        service.save("这是要保存的数据");
    }
}