package chapter03.node01.point03.wait_notify_size5;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:45
 */
public class Run {
    public static void main(String[] args) {
        try {
            Object lock=new Object();

            ThreadA a=new ThreadA(lock);
            a.setName("A");
            a.start();
            Thread.sleep(50);
            ThreadB b=new ThreadB(lock);
            b.setName("B");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
