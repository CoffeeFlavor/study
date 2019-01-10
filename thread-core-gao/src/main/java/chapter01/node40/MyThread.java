package chapter01.node40;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 14:28
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run="+this.isAlive());
    }
}
