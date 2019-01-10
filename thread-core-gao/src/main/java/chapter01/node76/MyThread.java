package chapter01.node76;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 16:58
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e) {
            System.out.println(" 进入了catch（）方法！");
            e.printStackTrace();
        }
    }
}
