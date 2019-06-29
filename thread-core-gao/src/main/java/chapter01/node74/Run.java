package chapter01.node74;


/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 16:44
 */
public class Run {
    public static void main(String[] args) {
        MyThread thread=new MyThread();
        thread.start();
        thread.interrupt();
    }
}
