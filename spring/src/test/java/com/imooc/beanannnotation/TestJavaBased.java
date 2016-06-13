package com.imooc.beanannnotation;

import com.imooc.base.UnitTestBase;
import com.imooc.beanannnotation.javabased.MyDriverManager;
import com.imooc.beanannnotation.javabased.Store;
import com.imooc.beanannnotation.javabased.StoreConfig;
import com.imooc.beanannnotation.javabased.StringStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * User: jennie
 * Date: 2016/6/13
 * Time: 14:44
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestJavaBased extends UnitTestBase {

    public TestJavaBased() {
        super("classpath:/spring/spring-beanannotation.xml");
    }

    @Test
    public void test(){
        Store store=super.getBean("store");
        System.out.println(store.getClass().getName());
    }

    @Test
    public void testMyDriverManger(){
        MyDriverManager manager=super.getBean("myDriverManager");
        System.out.println(manager.getClass().getName());
//        System.out.println(StoreConfig.myName);
//        System.out.println(StoreConfig.myName);
//        System.out.println(StoreConfig.myName);
    }

    @Test
    public void testScope(){
        Store store=super.getBean("stringStore");
        System.out.println(store.hashCode());

        store=super.getBean("stringStore");
        System.out.println(store.hashCode());
    }

    @Test
    public void testGernericity(){

        Store store=super.getBean("stringStoreTest");

    }}
