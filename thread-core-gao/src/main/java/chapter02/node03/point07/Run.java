package chapter02.node03.point07;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:05
 */
public class Run {

    public static void main(String[] args) {
        try {
            Service service=new Service();
            ThreadA  a=new ThreadA(service);
            a.start();

            Thread.sleep(1000);
            ThreadB b=new ThreadB(service);
            b.start();
            System.out.println(" 已经发起停止的命令了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
