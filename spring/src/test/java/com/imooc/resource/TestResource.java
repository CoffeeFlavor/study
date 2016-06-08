package com.imooc.resource;

import com.imooc.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * User: jennie
 * Date: 2016/6/8
 * Time: 17:38
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestResource extends UnitTestBase{

    public TestResource() {
        super("classpath:spring/spring-resource.xml");
    }

    @Test
    public void testResource(){
        MoocResource resource=super.getBean("moocResource");
        try {
            resource.resource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}