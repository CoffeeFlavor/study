package chapter02.node03.point03;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 15:50
 */
public class RunThread extends Thread{

    private volatile boolean isRunning=true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入 run 了 ");
        while (isRunning==true){
        }
        System.out.println(" 线程被停止了！");
    }
}
