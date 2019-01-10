package chapter01.node82;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 16:10
 */
public class MyThread extends Thread {
    private long i=0;

    @Override
    public void run() {
        while (true){
            i++;
            System.out.println(i);
        }
    }
}
