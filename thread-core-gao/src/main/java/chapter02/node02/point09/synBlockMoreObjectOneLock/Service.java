package chapter02.node02.point09.synBlockMoreObjectOneLock;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:53
 */
public class Service {

     public static void printA() {

         synchronized (Service.class) {
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
     }


     public static void printB() {
        synchronized (Service.class) {
            System.out.println(" 线程名字：" + Thread.currentThread().getName()
                    + " 在 " + System.currentTimeMillis() + " 进入printB");
            System.out.println(" 线程名字：" + Thread.currentThread().getName()
                    + " 在 " + System.currentTimeMillis() + " 离开printB");
        }
    }
}
