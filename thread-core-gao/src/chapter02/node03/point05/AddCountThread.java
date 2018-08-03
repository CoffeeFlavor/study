package chapter02.node03.point05;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 16:36
 */
public class AddCountThread  extends Thread {

    private AtomicInteger count=new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}