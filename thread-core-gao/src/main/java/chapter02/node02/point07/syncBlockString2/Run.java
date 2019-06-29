package chapter02.node02.point07.syncBlockString2;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 14:14
 */
public class Run {
    public static void main(String[] args) {
        Service service=new Service();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b=new ThreadB(service);
        b.setName("B");
        b.start();


    }
}
