package chapter01.node21;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 11:31
 */
public class Run03 {
    public static void main(String[] args) {
        Mythread03 t11=new Mythread03(1);
        Mythread03 t12=new Mythread03(2);
        Mythread03 t13=new Mythread03(3);
        Mythread03 t14=new Mythread03(4);
        Mythread03 t15=new Mythread03(5);
        Mythread03 t16=new Mythread03(6);
        Mythread03 t17=new Mythread03(7);
        Mythread03 t18=new Mythread03(8);
        Mythread03 t19=new Mythread03(9);
        Mythread03 t110=new Mythread03(10);
        Mythread03 t112=new Mythread03(12);
        Mythread03 t113=new Mythread03(13);

        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        t17.start();
        t18.start();
        t19.start();
        t110.start();
        t112.start();
        t113.start();
    }
}
