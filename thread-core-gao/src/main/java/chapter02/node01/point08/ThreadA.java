package chapter02.node01.point08;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:14
 */
public class ThreadA extends Thread {

    public Sub  sub;

    public ThreadA(Sub sub){
        this.sub=sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
