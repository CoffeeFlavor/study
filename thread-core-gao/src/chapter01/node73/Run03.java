package chapter01.node73;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 16:11
 */
public class Run03 {
    public static void main(String[] args) {
        try {
            Mythread03 thread=new Mythread03();
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
