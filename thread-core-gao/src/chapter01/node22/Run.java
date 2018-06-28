package chapter01.node22;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 11:43
 */
public class Run {
    public static void main(String[] args) {
        Runnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
        System.out.println("运行结束！"
        );
    }

}
