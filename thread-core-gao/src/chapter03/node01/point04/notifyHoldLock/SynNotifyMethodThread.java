package chapter03.node01.point04.notifyHoldLock;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:56
 */
public class SynNotifyMethodThread extends Thread {

    private Object lock;

    public SynNotifyMethodThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service=new Service();
        service.synNotifyMethod(lock);
    }
}
