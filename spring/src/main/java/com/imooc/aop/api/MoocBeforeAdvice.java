package com.imooc.aop.api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * User: jennie
 * Date: 2016/6/20
 * Time: 10:21
 */
public class MoocBeforeAdvice  implements MethodBeforeAdvice{


    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MoocBeforeAdvice : "+method.getName()+"    "+
                target.getClass().getName());

    }
}
