package chapter02.node02.point08.test2;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:03
 */
public class MyObject {

    synchronized public void speedPrintString() {
        System.out.println("speedPrintString ___getLock time="
                + System.currentTimeMillis() + " run ThreadName="
                + Thread.currentThread().getName());
        System.out.println("------------------");
        System.out.println("speedPrintString ___releaseLock time="
                + System.currentTimeMillis() + " run ThreadName="
                + Thread.currentThread().getName());

    }

}
