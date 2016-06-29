package com.imooc.aop.api;

import org.springframework.aop.ThrowsAdvice;

import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * User: jennie
 * Date: 2016/6/20
 * Time: 10:26
 */

public class MoocThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex)throws Throwable{
        System.out.println("MoocThrowsAdvice afterThrowing 1");
    }

    public void afterThrowing(Method method,Object[] args,Exception ex)throws Throwable{
        System.out.println("MoocThrowsAdvice afterThrowing 2"+method.getName()+"   "+
                Target.class.getName());
    }
}
