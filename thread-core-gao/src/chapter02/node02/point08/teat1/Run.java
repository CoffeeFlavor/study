package chapter02.node02.point08.teat1;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 16:10
 */
public class Run {

    public static void main(String[] args) {
        Service service=new Service();
        MyObject object1=new MyObject();

        MyObject object2=new MyObject();
        ThreadA a=new ThreadA(service,object1);
        a.setName("a");
        a.start();

        ThreadB b=new ThreadB(service,object1);
        b.setName("b");
        b.start();
    }
}
