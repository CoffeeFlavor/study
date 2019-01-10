package chapter03.node01.point05;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:44
 */
public class Test {

    public static void main(String[] args) throws InterruptedException{
        Object lock=new Object();
        ThreadA a=new ThreadA(lock);
        a.start();

        Thread.sleep(5000);
        a.interrupt();
    }
}
