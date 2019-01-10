package chapter01.node71;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:15
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("i="+(i+1));
        }
    }
}
