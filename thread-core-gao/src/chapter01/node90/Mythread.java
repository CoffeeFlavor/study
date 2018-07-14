package chapter01.node90;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 11:28
 */
public class Mythread extends Thread {
    @Override
    public void run() {
        long beginTime=System.currentTimeMillis();
        int count=0;
        for (int i = 0; i < 50000000; i++) {
//            Thread.yield();
            count=count+(i+1);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("用时： "+(endTime-beginTime)+" 毫秒");
    }

}
