package chapter02.node03.point06;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 16:45
 */
public class MyThread extends Thread {

    private MyService service;

    public MyThread(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.addNum();
    }
}
