package chapter03.node01.point11.p_c_allWait_fix;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:43
 */
public class C {

    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                while (ValueObject.value.equals("")){
                    System.out.println(" 消费者 "
                            +Thread.currentThread().getName()+" WAITING 了 ☆");
                    lock.wait();
                }
                System.out.println(" 消费者 "
                        +Thread.currentThread().getName()+" RUNNABLE 了 ");
                ValueObject.value="";
                lock.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
