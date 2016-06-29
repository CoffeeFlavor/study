package com.imooc.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * User: jennie
 * Date: 2016/6/20
 * Time: 10:46
 */
public class MoocMethodInterceptor implements MethodInterceptor {


    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("MoocMethodInterceptor 1 : "+invocation.getMethod().getName()+"    "+
        invocation.getStaticPart().getClass().getName());
        Object obj= invocation.proceed();
        System.out.println("MoocMethodInterceptor 1 :"+obj);
        return obj;
    }
}
