package chapter01.node30;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 14:21
 */
public class CountOperate extends Thread {
    public CountOperate(){
        System.out.println("CountOperate--begin");
        System.out.println("Thread.currentThread.getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()"+this.getName());
        System.out.println("CountOperate--end");
    }

    @Override
    public void run() {
        System.out.println("run--begin");
        System.out.println("Thread.currentThread.getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()"+this.getName());
        System.out.println("run--end");
    }
}
