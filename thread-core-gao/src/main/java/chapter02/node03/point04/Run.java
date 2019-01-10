package chapter02.node03.point04;


/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 16:24
 */
public class Run {
    public static void main(String[] args) {
        MyThread[] myThreadArray=new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreadArray[i]=new MyThread();
        }
        for (int i = 0; i < 100; i++) {
            myThreadArray[i].start();
        }
    }
}
