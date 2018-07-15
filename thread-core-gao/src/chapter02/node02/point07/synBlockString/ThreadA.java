package chapter02.node02.point07.synBlockString;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 14:12
 */
public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("a","aa");
    }
}
