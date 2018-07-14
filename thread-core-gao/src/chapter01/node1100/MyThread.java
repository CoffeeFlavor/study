package chapter01.node1100;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 12:35
 */
public class MyThread extends Thread {
    private int i=0;

    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("守护 i="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
