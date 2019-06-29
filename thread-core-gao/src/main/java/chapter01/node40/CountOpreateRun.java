package chapter01.node40;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 14:36
 */
public class CountOpreateRun {
    public static void main(String[] args) {
        CountOperate c=new CountOperate();
        Thread t1=new Thread(c);
        System.out.println("main begin t1 isAlive="+t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive="+t1.isAlive());
    }
}
