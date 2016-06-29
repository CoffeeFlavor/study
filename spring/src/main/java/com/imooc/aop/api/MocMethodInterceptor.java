package com.imooc.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * User: jennie
 * Date: 2016/6/29
 * Time: 11:06
 */
public class MocMethodInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("MocMethodInterceptor1 : " + invocation.getMethod().getName() + "   "
                + invocation.getStaticPart().getClass().getName());
        Object obj = invocation.proceed();
        System.out.println("MocMethodInterceptor 2:"+obj);
        return obj;
    }
}
