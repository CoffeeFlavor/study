package chapter02.node01.point06;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:35
 */
public class SubThread extends Thread {
    @Override
    public void run() {
        Sub sub=new Sub();
        sub.operateSubMethod();
    }
}
