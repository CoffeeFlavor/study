package chapter02.node02.point08.test2;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:08
 */
public class ThreadA extends Thread {

    private Service service;

    private MyObject object;

    public ThreadA(Service service, MyObject object) {
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}
