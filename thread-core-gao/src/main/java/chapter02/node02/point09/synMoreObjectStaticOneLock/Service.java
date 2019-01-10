package chapter02.node02.point09.synMoreObjectStaticOneLock;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:53
 */
public class Service {

    synchronized public static void printA() {
        try {
            System.out.println(" 线程名字：" + Thread.currentThread().getName()
                    + " 在 " + System.currentTimeMillis() + " 进入printA");
            Thread.sleep(3000);
            System.out.println(" 线程名字：" + Thread.currentThread().getName()
                    + " 在 " + System.currentTimeMillis() + " 离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    synchronized public static void printB() {
        System.out.println(" 线程名字：" + Thread.currentThread().getName()
                + " 在 " + System.currentTimeMillis() + " 进入printB");
        System.out.println(" 线程名字：" + Thread.currentThread().getName()
                + " 在 " + System.currentTimeMillis() + " 离开printB");
    }
}
