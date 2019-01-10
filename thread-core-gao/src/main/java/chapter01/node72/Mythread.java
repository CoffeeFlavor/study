package chapter01.node72;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:21
 */
public class Mythread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i="+(i+1));
        }
    }
}
