package chapter01.node40;

import chapter01.node21.Mythread03;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 14:29
 */
public class Run{
    public static void main(String[] args) {
    MyThread myThread=new MyThread();
        System.out.println("begin =="+myThread.isAlive());
        myThread.start();
        System.out.println("end =="+myThread.isAlive());
    }
}
