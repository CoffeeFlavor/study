package chapter01.node78;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 15:00
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Mythread t=new Mythread();
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }

}
