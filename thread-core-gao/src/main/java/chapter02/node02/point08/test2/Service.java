package chapter02.node02.point08.test2;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:03
 */
public class Service {

     public void testMethod1(MyObject object) {
         synchronized (object) {
             try {
                 System.out.println("testMethod1 ___getLock time="
                         + System.currentTimeMillis() + " run ThreadName="
                         + Thread.currentThread().getName());
                 Thread.sleep(5000);
                 System.out.println("testMethod1 ___releaseLock time="
                         + System.currentTimeMillis() + " run ThreadName="
                         + Thread.currentThread().getName());
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
}
