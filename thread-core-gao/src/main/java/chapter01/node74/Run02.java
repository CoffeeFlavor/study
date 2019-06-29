package chapter01.node74;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 16:50
 */
public class Run02 {
    public static void main(String[] args) {
        MyThread02 thread = new MyThread02();
        thread.start();
        thread.interrupt();
        System.out.println("end");
    }
}
