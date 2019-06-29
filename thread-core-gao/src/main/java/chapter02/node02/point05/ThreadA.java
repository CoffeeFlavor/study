package chapter02.node02.point05;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:59
 */
public class ThreadA extends Thread {

    private ObjectService service;

    public ThreadA(ObjectService service){
        this.service =service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethodA();
    }
}
