package chapter03.node01.point10;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:25
 */
public class ThreadAdd extends Thread{

    private Add p;

    public ThreadAdd(Add p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.add();
    }
}
