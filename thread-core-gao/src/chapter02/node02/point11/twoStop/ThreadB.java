package chapter02.node02.point11.twoStop;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 17:39
 */
public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}
