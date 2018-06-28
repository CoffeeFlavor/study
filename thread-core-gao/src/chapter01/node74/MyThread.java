package chapter01.node74;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 16:42
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(1000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止！进入catch！"+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
