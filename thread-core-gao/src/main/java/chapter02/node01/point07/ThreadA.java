package chapter02.node01.point07;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:49
 */
public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service){
        this.service=service;
    }
    @Override
    public void run() {
        service.testMethod();
    }
}
