package chapter01.node1040;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 12:22
 */
public class ThreadB extends Thread {
    private int count=0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (true){
            count++;
            if (this.isInterrupted()){
                break;
            }
        }
    }
}
