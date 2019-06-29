package chapter01.node1040;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 12:23
 */
public class Run {
    public static void main(String[] args) {
        try {
            ThreadA a=new ThreadA();
            a.setPriority(Thread.NORM_PRIORITY-3);
            a.start();

            ThreadB b=new ThreadB();
            b.setPriority(Thread.NORM_PRIORITY+3);
            b.start();
            Thread.sleep(20000);
            a.interrupt();
            b.interrupt();
            System.out.println("a="+a.getCount());
            System.out.println("b="+b.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
