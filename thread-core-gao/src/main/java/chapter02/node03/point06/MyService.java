package chapter02.node03.point06;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 16:42
 */
public class MyService {

    public static AtomicLong aiRef=new AtomicLong();

   synchronized public void addNum(){
        System.out.println(Thread.currentThread().getName()+" 加了100之后的值是："
        +aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}
