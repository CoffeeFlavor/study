package chapter03.node01.point04.notifyHoldLock;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:56
 */
public class NotifyThread extends Thread {

    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service=new Service();
        service.synNotifyMethod(lock);
    }
}
