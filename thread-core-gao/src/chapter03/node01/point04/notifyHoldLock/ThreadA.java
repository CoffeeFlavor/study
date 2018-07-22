package chapter03.node01.point04.notifyHoldLock;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:56
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service=new Service();
        service.testMethod(lock);
    }
}
