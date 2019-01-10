package chapter01.node75;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 16:55
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread=new MyThread();
            thread.start();
            Thread.sleep(8000);
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
