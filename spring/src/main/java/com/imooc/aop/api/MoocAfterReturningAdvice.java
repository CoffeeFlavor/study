package com.imooc.aop.api;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * User: jennie
 * Date: 2016/6/20
 * Time: 10:32
 */
public class MoocAfterReturningAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("MoocAfterReturningAdvice:"+method.getName()+"    "+
        target.getClass().getName()+"   "+returnValue);
    }
}
