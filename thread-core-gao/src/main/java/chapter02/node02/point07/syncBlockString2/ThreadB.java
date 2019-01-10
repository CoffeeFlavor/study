package chapter02.node02.point07.syncBlockString2;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 14:12
 */
public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        service.b();
    }
}
