package chapter01.node50;

import chapter01.node40.MyThread;

import java.util.Currency;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:03
 */
public class Run1 {
    public static void main(String[] args) {
        MyThread1 myThread=new MyThread1();
        System.out.println("begin ="+System.currentTimeMillis());
        myThread.run();
        System.out.println("end ="+System.currentTimeMillis());
    }
}
