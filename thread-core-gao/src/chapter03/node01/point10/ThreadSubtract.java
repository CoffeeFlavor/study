package chapter03.node01.point10;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:26
 */
public class ThreadSubtract extends Thread{

    private Subtract r;

    public ThreadSubtract(Subtract r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}
