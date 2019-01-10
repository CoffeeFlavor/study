package chapter02.node02.point10.StringAndSync2;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 17:22
 */
public class Service {

    public static void print(Object object){
        try {
            synchronized (object){
                while (true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
