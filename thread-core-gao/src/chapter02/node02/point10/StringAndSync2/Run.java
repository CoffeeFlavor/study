package chapter02.node02.point10.StringAndSync2;


/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:58
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
