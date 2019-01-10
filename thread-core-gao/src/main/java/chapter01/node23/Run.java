package chapter01.node23;

import chapter01.node21.Mythread03;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 12:02
 */
public class Run {
    public static void main(String[] args) {
        MyThread a=new MyThread("A");
        MyThread b=new MyThread("B");
        MyThread c=new MyThread("C");
        a.start();;
        b.start();;
        c.start();
    }
}
