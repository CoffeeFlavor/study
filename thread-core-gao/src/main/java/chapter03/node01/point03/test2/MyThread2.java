package chapter03.node01.point03.test2;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 11:17
 */
public class MyThread2 extends Thread {

    private final Object lock;

    public MyThread2(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(" 开始 notify time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println(" 结束 notify time=" + System.currentTimeMillis());
        }
    }
}
