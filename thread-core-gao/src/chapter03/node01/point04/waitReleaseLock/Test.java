package chapter03.node01.point04.waitReleaseLock;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:44
 */
public class Test {

    public static void main(String[] args) {
        Object lock=new Object();
        ThreadA a=new ThreadA(lock);
        a.start();

        ThreadB b=new ThreadB(lock);
        b.start();
    }
}
