package chapter02.node02.point08.test2;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:08
 */
public class ThreadB extends Thread {
    private MyObject object;

    public ThreadB(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.speedPrintString();
    }
}
