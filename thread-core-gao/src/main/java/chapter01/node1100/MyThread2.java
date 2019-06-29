package chapter01.node1100;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 12:35
 */
public class MyThread2 extends Thread {
    private int i=0;

    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("i="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
