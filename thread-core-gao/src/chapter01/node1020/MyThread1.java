package chapter01.node1020;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.Random;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 11:57
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        long beginTime=System.currentTimeMillis();
        long addResult=0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random=new Random();
                random.nextInt();
                addResult=addResult+i;
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println("★ ★ ★  ★ ★ thread 1 use time="+(endTime-beginTime));
    }
}
