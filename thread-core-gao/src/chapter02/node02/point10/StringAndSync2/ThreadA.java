package chapter02.node02.point10.StringAndSync2;


/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:57
 */
public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.print(new Object());
    }
}
