package chapter03.node01.point07;

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

        ThreadB b=new ThreadB(lock);
        b.start();

        ThreadC c=new ThreadC(lock);
        c.start();
        Thread.sleep(1000);
        NotifyThread notifyThread=new NotifyThread(lock);
        notifyThread.start();
    }
}
