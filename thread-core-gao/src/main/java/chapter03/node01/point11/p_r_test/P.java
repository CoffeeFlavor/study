package chapter03.node01.point11.p_r_test;


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
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value=System.currentTimeMillis()+"_"
                        +System.nanoTime();
                ValueObject.value=value;
                System.out.println("set 的值是 "+value);
                lock.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
