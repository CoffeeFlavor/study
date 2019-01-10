package chapter01.node21;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 11:17
 */
public class Run {

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
        System.out.println(" 运行结束！ ");
    }
}
