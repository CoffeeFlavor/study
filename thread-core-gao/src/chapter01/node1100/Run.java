package chapter01.node1100;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 12:37
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread=new MyThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            MyThread2 thread2=new MyThread2();
            thread2.start();
            System.out.println(" 我离开 thread对象也不再打印了，也就是停止了！ ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
