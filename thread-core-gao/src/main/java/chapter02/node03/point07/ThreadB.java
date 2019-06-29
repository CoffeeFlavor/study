package chapter02.node03.point07;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:04
 */
public class ThreadB extends Thread{

    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.stopMethod();
    }
}
