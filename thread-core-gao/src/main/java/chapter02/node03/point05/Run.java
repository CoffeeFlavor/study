package chapter02.node03.point05;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 16:39
 */
public class Run {
    public static void main(String[] args) {

        AddCountThread countService=new AddCountThread();
        Thread t1=new Thread(countService);
        t1.start();
        Thread t2=new Thread(countService);
        t2.start();

        Thread t3=new Thread(countService);
        t3.start();

        Thread t4=new Thread(countService);
        t4.start();

        Thread t5=new Thread(countService);
        t5.start();

    }

}
