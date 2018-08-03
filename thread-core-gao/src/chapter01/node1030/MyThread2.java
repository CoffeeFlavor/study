package chapter01.node1030;

import java.util.Random;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 12:03
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {
        long beginTime=System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                Random random=new Random();
                random.nextInt();
            }
        long endTime=System.currentTimeMillis();
        System.out.println("☆ ☆ ☆ ☆ ☆ thread 2 use time="+(endTime-beginTime));

    }
}
