package chapter01.node24;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 10:57
 */
public class MyThread extends Thread {

    private int i=5;

    @Override
    public  void run() {
        System.out.println("i="+(i--)+" threadName="+Thread.currentThread().getName());
    }

}
