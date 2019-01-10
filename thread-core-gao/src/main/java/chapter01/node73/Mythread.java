package chapter01.node73;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:21
 */
public class Mythread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.isInterrupted()){
                System.out.println(" 已经是停止状态了！我要退出！");
                break;
            }
            System.out.println("i="+(i+1));
        }
    }
}
