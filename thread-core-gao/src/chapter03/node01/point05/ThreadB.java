package chapter03.node01.point05;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:42
 */
public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service=new Service();
        service.testMethod(lock);
    }
}
