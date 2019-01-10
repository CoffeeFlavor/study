package chapter03.node01.point03.test2;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 11:25
 */
public class Run {

    public static void main(String[] args) {

        try {
            Object lock=new Object();
            MyThread1 t1=new MyThread1(lock);
            t1.start();

            Thread.sleep(3000);

            MyThread2 t2=new MyThread2(lock);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
