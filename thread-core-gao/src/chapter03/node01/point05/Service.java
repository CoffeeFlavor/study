package chapter03.node01.point05;

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
            System.out.println(" 出现异常了，因为呈wait状态的线程被interrupt");
        }
    }


}
