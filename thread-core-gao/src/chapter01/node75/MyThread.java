package chapter01.node75;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 16:53
 */
public class MyThread extends Thread {

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
