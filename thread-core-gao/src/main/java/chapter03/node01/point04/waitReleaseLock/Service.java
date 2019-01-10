package chapter03.node01.point04.waitReleaseLock;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 14:41
 */
public class Service {
    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin wait()");
                lock.wait();
//                Thread.sleep(200);
                System.out.println("end wait()");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
