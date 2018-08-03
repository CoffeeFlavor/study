package chapter02.node02.point02;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:59
 */
public class ThreadB extends Thread {

    private ObjectService service;

    public ThreadB(ObjectService service){
        this.service =service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethod();
    }
}
