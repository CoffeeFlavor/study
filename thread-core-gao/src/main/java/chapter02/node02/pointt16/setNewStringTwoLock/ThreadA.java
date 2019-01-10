package chapter02.node02.pointt16.setNewStringTwoLock;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 14:30
 */
public class ThreadA extends Thread {

    private MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
