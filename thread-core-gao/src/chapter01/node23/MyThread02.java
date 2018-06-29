package chapter01.node23;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 12:04
 */
public class MyThread02 extends Thread {

    private int count=5;

    @Override
   synchronized   public void run() {
        super.run();
            count--;
            System.out.println("由 "+Thread.currentThread().getName()+" 计算，count="+count);
    }
}
