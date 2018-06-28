package chapter01.node50;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:07
 */
public class Run2 {

    public static void main(String[] args) {
        MyThread2 myThread=new MyThread2();
        System.out.println("begin ="+System.currentTimeMillis());
        myThread.start();
        System.out.println("end ="+System.currentTimeMillis());
    }

}
