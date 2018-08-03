package chapter03.node01.point06;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:42
 */
public class NotifyThread extends Thread {

    private Object lock;

    public NotifyThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
//            lock.notify();
        }
    }
}
