package chapter01.node73;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 16:11
 */
public class Run02 {
    public static void main(String[] args) {
        try {
            Mythread02 thread=new Mythread02();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
