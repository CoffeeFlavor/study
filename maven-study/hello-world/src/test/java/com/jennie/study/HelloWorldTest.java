package com.jennie.study;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author : jennie
 * @date: 2019/6/30
 * @Time: 15:20
 */
public class HelloWorldTest {


    @Test
    public void sayHello() {
        HelloWorld helloWorld=new HelloWorld();
        String result=helloWorld.sayHello();
        assertEquals("Hello World",result);
    }
}
