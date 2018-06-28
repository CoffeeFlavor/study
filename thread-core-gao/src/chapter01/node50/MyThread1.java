package chapter01.node50;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:00
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
    try {
        System.out.println("run threadName="+Thread.currentThread().getName()+" begin");
        Thread.sleep(2000);
        System.out.println("run threadName="+Thread.currentThread().getName()+" end");
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    }
}
