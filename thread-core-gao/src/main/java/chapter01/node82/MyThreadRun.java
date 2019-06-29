package chapter01.node82;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 16:11
 */
public class MyThreadRun {
    public static void main(String[] args) {
        try {
            MyThread thread=new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.suspend();
            System.out.println("mian end !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
