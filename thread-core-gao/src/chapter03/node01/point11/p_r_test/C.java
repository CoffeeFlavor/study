package chapter03.node01.point11.p_r_test;

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
                if (ValueObject.value.equals("")){
                    lock.wait();
                }

                System.out.println("get 的值是 "+ValueObject.value);
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
