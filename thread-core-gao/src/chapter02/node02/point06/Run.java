package chapter02.node02.point06;


/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 18:01
 */
public class Run {
    public static void main(String[] args) {
        try {
            Task task=new Task();
            ThreadA a=new ThreadA(task);
            a.setName("a");
            a.start();

            Thread.sleep(100);
            ThreadB b=new ThreadB(task);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
