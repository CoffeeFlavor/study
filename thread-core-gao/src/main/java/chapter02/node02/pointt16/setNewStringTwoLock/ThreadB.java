package chapter02.node02.pointt16.setNewStringTwoLock;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 14:30
 */
public class ThreadB extends Thread {

    private MyService service;

    public ThreadB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
