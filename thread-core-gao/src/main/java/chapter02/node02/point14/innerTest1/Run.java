package chapter02.node02.point14.innerTest1;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 11:32
 */
public class Run {

    public static void main(String[] args) {

        final OutClass.Inner inner=new OutClass.Inner();
        Thread t1=new Thread(() -> {
            inner.method1();
        },"A");

        Thread t2=new Thread(() -> {
            inner.method2();
        },"B");

        t1.start();
        t2.start();
    }
}
