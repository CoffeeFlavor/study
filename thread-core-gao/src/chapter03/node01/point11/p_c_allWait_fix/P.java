package chapter03.node01.point11.p_c_allWait_fix;


/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:38
 */
public class P {

    private String lock;

    public P(String lock) {
        super();
        this.lock = lock;
    }

    public void setValued(){
        try {
            synchronized (lock){
                while (!ValueObject.value.equals("")){
                    System.out.println(" 生产者 "
                    +Thread.currentThread().getName()+" WAITING 了 ★");
                    lock.wait();
                }
                System.out.println(" 生产者 "
                        +Thread.currentThread().getName()+" RUNNABLE 了 ");
                String value=System.currentTimeMillis()+"_"
                        +System.nanoTime();
                ValueObject.value=value;
                lock.notifyAll();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
