package springinaction.study.chapter04.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author : jennie
 * @date: 2019/7/28
 * @Time: 11:09
 */
@Aspect
public class Audience {

    @Pointcut("execution(* springinaction.study.chapter04.concert.Performance.perform(..))")
    public void performance(){

    };

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silencing call phones");
    }

    @Before(value = "performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }
    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("Silencing cell phone ");
            System.out.println(" Take seats");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP");
        }catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
