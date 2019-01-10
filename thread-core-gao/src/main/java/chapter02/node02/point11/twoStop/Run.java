package chapter02.node02.point11.twoStop;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 17:40
 */
public class Run {

    public static void main(String[] args) {
        Service service=new Service();
        ThreadA a=new ThreadA(service);
        a.start();

        ThreadB b=new ThreadB(service);
        b.start();
    }
}
