package chapter01.node30;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 14:24
 */
public class CountOperateRun {
    public static void main(String[] args) {
        CountOperate c=new CountOperate();
        Thread t1=new Thread(c);
        t1.setName("A");
        t1.start();
    }
}
