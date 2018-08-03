package chapter02.node01.point04;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:48
 */
public class Run {
    public static void main(String[] args) {
        MyObject object=new MyObject();
        ThreadA a=new ThreadA(object);
        a.setName("A");

        ThreadB b=new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();

    }
}
