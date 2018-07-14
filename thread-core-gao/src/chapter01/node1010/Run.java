package chapter01.node1010;

import chapter01.node90.Mythread;

import javax.xml.transform.Source;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 11:49
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority="+Thread.currentThread().getPriority());
        MyThread1 thread1=new MyThread1();
        thread1.setPriority(10);

        thread1.start();
    }
}
