package chapter02.node02.point09.synTwoLock;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:57
 */
public class ThreadA extends Thread {

    @Override
    public void run() {
        Service.printA();
    }
}
