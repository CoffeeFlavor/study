package chapter01.node1010;

import chapter01.node23.MyThread;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 11:47
 */
public class MyThread1 extends Thread {


    @Override
    public void run() {
        System.out.println("MyThread1 run priority= "+this.getPriority());
        MyThread2 thread2=new MyThread2();
        thread2.start();
    }
}
