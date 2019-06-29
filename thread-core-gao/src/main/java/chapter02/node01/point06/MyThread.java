package chapter02.node01.point06;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:26
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        Service service=new Service();
        service.service1();
    }
}
