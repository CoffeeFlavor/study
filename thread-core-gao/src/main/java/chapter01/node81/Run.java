package chapter01.node81;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 15:26
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread=new MyThread();
            thread.start();
            System.out.println(thread.getI());
            Thread.sleep(5000);

            //A段
            thread.suspend();
            System.out.println("A="+System.currentTimeMillis()+" i="+thread.getI());
            Thread.sleep(5000);
            System.out.println("A="+System.currentTimeMillis()+" i="+thread.getI());

            //B段
            thread.resume();
            Thread.sleep(5000);

            //C段
            thread.suspend();
            System.out.println("B="+System.currentTimeMillis()+" i="+thread.getI());
            Thread.sleep(5000);
            System.out.println("B="+System.currentTimeMillis()+" i="+thread.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
