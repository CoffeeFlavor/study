package chapter02.node02.point12.deadLockTest;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 17:53
 */
public class DealThread implements Runnable {


    private String username;

    private Object lock1=new Object();
    private Object lock2=new Object();

    public void setFlag(String ussername){
        this.username=ussername;
    }

    @Override
    public void run() {

        if (username.equals("a")){
            synchronized (lock1){
                try {
                    System.out.println("username= "+username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(" 按 lock1->lock2 代码顺利执行了");
                }

            }
        }

        if (username.equals("b")){
            synchronized (lock2){
                try {
                    System.out.println("username= "+username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(" 按 lock2->lock1 代码顺利执行了");
                }
            }
        }
    }
}
