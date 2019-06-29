package chapter01.node21;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 11:21
 */
public class MyThread02 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time=(int) (Math.random()*1000);
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
