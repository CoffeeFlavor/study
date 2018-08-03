package chapter02.node03.point06;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 16:46
 */
public class Run {


    public static void main(String[] args) {
        try {
            MyService service=new MyService();
            MyThread[] array=new MyThread[5];

            for (int i = 0; i < array.length; i++) {
                array[i]=new MyThread(service);
            }

            for (int i = 0; i < array.length; i++) {
                array[i].start();
            }

            Thread.sleep(1000);
            System.out.println(MyService.aiRef);

        }catch (Exception e){

        }
    }
}
