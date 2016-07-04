package com.imooc.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * User: jennie
 * Date: 2016/7/1
 * Time: 11:21
 */
@Aspect
@Component
public class MoocAspect {

    @Pointcut("execution(String com.imooc.aop.aspectj.biz.*Biz.*(..))")
    public void pointcut() {
    }

    @Pointcut("within(com.imooc.aop.aspectj.biz.MoocBiz)")
    public void bizPointcut() {
    }


    @Before("pointcut()")
    public void before() {
        System.out.println("Before");
    }

    @Before("pointcut()&&args(arg)")
    public void beforeWithParams(String arg) {
        System.out.println("BeforeWithParams:"+arg);

    }

    @Before("pointcut()&&@annotation(moocMethod)")
    public void beforeWithAnnotation(MoocMethod moocMethod) {
        System.out.println("BeforeWithAnnotation:"+moocMethod.value());

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
        System.out.println(e);
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("Around 1");
        Object obj=pjp.proceed();
        System.out.println("Around 2");
        System.out.println("Around:"+obj);
        return obj;
    }

}
