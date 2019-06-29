package chapter01.node78;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 14:59
 */
public class Mythread extends Thread {

    @Override
    public void run() {
        while (true){
            if (this.isInterrupted()) {
                System.out.println("停止了");
                return;
            }
        }
    }
}
