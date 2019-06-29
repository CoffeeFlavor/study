package chapter02.node02.point04;


/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 18:01
 */
public class Run {
    public static void main(String[] args) {
        Task task=new Task();
        ThreadA a=new ThreadA(task);
        a.setName("a");
        a.start();

        ThreadB b=new ThreadB(task);
        b.setName("b");
        b.start();
    }
}
