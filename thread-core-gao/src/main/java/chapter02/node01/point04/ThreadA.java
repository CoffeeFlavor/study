package chapter02.node01.point04;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:46
 */
public class ThreadA extends Thread {
    private MyObject object;

    public ThreadA(MyObject object){
        super();
        this.object=object;
    }

    @Override
    public void run() {
        super.run();
        object.methoedA();
    }
}
