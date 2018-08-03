package chapter02.node03.point04;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 16:22
 */
public class MyThread extends Thread {

    volatile  public static int count;

   synchronized private static void  addCount(){
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count="+count);
    }

    @Override
    public void run() {
        addCount();
    }
}
