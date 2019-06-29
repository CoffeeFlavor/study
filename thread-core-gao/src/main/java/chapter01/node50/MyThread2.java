package chapter01.node50;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:06
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run threadName="+Thread.currentThread().getName()+" begin="+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run threadName="+Thread.currentThread().getName()+" end="+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
