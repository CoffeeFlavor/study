package com.imooc.aop.aspectj;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Component;

/**
 * User: jennie
 * Date: 2016/7/1
 * Time: 11:21
 */
@Aspect
@Component
public class MoocAspect {

    @Pointcut("execution(* com.imooc.aop.aspectj.biz.*Biz.*(..))")
    public void pointcut() {
    }

    @Pointcut("within(com.imooc.aop.aspectj.biz.MoocBiz)")
    public void bizPointcut() {
    }


    @Before("pointcut()")
    public void before() {
        System.out.println("Before");
    }


    @AfterReturning(pointcut ="pointcut()",returning = "returnValue")
    public void afterReturning(Object returnValue){
        System.out.println("AfterReturning : "+returnValue);
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after");
    }

    @AfterThrowing(pointcut="pointcut()",throwing ="e" )
    public void afterThrowing(RuntimeException e){
        System.out.println("AfterThrowing");
    }


}
