package chapter02.node02.pointt16.setNewStringTwoLock;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 14:29
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException{
        MyService service=new MyService();
        ThreadA a=new ThreadA(service);
        a.setName("A");

        ThreadB b=new ThreadB(service);
        b.setName("B");

        a.start();
        b.start();
    }
}
