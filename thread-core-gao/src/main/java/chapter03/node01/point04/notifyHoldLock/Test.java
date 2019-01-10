package chapter03.node01.point04.notifyHoldLock;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:57
 */
public class Test {

    public static void main(String[] args) {
        Object lock=new Object();
        ThreadA a=new ThreadA(lock);
        a.start();

        NotifyThread notifyThread=new NotifyThread(lock);
        notifyThread.start();

        SynNotifyMethodThread c=new SynNotifyMethodThread(lock);
        c.start();
    }
}
