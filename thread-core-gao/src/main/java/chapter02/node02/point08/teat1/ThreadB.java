package chapter02.node02.point08.teat1;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:08
 */
public class ThreadB extends Thread {

    private Service service;

    private MyObject object;

    public ThreadB(Service service, MyObject object) {
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}
