package chapter02.node01.point04;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:46
 */
public class ThreadB extends Thread {
    private MyObject object;

    public ThreadB(MyObject object){
        super();
        this.object=object;
    }

    @Override
    public void run() {
        super.run();
        object.methoedB();
    }
}
