package chapter01.node73;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:21
 */
public class Mythread03 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()){
                    System.out.println(" 已经是停止状态了！我要退出！");
                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }
            System.out.println(" 我在for 下面");
        } catch (InterruptedException e) {
            System.out.println("进 MyThread.java 类run 方法中的catch");
            e.printStackTrace();
        }
    }
}
