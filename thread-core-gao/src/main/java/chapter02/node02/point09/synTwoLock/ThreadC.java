package chapter02.node02.point09.synTwoLock;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:57
 */
public class ThreadC extends Thread {
    private Service service;

    public ThreadC(Service service) {
        this.service = service;
    }



    @Override
    public void run() {
        service.printC();
    }
}
