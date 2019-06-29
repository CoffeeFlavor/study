package chapter02.node02.point09.synTwoLock;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:58
 */
public class Run {

    public static void main(String[] args) {
        ThreadA a=new ThreadA();
        a.setName("A");
        a.start();

        ThreadB b=new ThreadB();
        b.setName("B");
        b.start();

        Service service=new Service();
        ThreadC c=new ThreadC(service);
        c.setName("C");
        c.start();
    }
}
