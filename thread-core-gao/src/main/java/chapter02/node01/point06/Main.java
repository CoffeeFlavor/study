package chapter02.node01.point06;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:29
 */
public class Main {

    public int i=10;

    synchronized public void operateImainMethod(){
        try {
            i--;
            System.out.println("main print i="+i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
