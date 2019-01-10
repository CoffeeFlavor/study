package chapter01.node82;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 15:52
 */
public class SynchronizedObject {
    synchronized public void pringString(){
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a 线程永远 suspend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
