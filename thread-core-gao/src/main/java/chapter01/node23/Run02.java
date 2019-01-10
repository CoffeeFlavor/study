package chapter01.node23;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 12:05
 */
public class Run02 {
    public static void main(String[] args) {
        MyThread02 myThread=new MyThread02();
        Thread a=new Thread(myThread,"A");
        Thread b=new Thread(myThread,"B");
        Thread c=new Thread(myThread,"C");
        Thread d=new Thread(myThread,"D");
        Thread e=new Thread(myThread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
