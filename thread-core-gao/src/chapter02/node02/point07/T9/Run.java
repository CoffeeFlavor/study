package chapter02.node02.point07.T9;

import java.util.List;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 15:33
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyOneList myList=new MyOneList();
        MyThread1 a=new MyThread1(myList);
        a.setName("A");
        a.start();
        MyThread2 b=new MyThread2(myList);
        b.setName("B");
        b.start();
        Thread.sleep(6000);

        System.out.println("listSize="+myList.getSize());
    }
}
