package chapter03.node01.point07;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:42
 */
public class ThreadC extends Thread {

    private Object lock;

    public ThreadC(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service=new Service();
        service.testMethod(lock);
    }
}
