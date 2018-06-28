package chapter01.node60;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:10
 */
public class Test {
    public static void main(String[] args) {
        Thread runThread=Thread.currentThread();

        System.out.println(runThread.getName()+" "+runThread.getId());
    }
}
