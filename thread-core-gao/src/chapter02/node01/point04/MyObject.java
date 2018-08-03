package chapter02.node01.point04;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:41
 */
public class MyObject {

    synchronized void  methoedA(){
        try {
            System.out.println("begin methodA threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void  methoedB(){
        try {
            System.out.println("begin methodB threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
