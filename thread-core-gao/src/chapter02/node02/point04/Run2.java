package chapter02.node02.point04;

import chapter02.node02.point02.ObjectService;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 18:01
 */
public class Run2 {
    public static void main(String[] args) {
        ObjectService service=new ObjectService();
        ThreadA a=new ThreadA(service);
        a.setName("a");
        a.start();

        ThreadB b=new ThreadB(service);
        b.setName("b");
        b.start();
    }
}
