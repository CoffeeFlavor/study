package chapter01.node1010;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 11:48
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread2 run priority="+this.getPriority());
    }
}
