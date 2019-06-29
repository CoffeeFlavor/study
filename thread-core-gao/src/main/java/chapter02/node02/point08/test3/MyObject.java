package chapter02.node02.point08.test3;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:03
 */
public class MyObject {

    public void speedPrintString() {
        synchronized (this) {
            System.out.println("speedPrintString ___getLock time="
                    + System.currentTimeMillis() + " run ThreadName="
                    + Thread.currentThread().getName());
            System.out.println("------------------");
            System.out.println("speedPrintString ___releaseLock time="
                    + System.currentTimeMillis() + " run ThreadName="
                    + Thread.currentThread().getName());

        }
    }

}
