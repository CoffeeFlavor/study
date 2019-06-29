package chapter02.node01.point07;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:51
 */
public class Run {

    public static void main(String[] args) {
        try {
            Service service=new Service();
            ThreadA a=new ThreadA(service);
            a.setName("a");
            a.start();
            Thread.sleep(500);
            ThreadB b=new ThreadB(service);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
