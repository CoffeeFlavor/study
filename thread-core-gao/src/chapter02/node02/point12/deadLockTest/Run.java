package chapter02.node02.point12.deadLockTest;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 17:59
 */
public class Run {
    public static void main(String[] args) {

        try {
            DealThread t1=new DealThread();
            t1.setFlag("a");
            Thread thread1=new Thread(t1);
            thread1.start();
            Thread.sleep(100);
            t1.setFlag("b");
            Thread thread2=new Thread(t1);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
