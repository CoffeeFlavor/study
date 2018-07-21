package chapter02.node02.pointt16.setNewStringTwoLock;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 14:26
 */
public class MyService {

    private String lock="123";

    public void testMethod(){
        try {
            synchronized (lock){
                System.out.println(
                        Thread.currentThread().getName()+" begin "
                                + System.currentTimeMillis()
                );
                lock="456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" end "
                +System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
