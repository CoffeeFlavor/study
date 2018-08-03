package chapter02.node02.pointt16.setNewPropertiesLockOne;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 14:29
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        Service service=new Service();
        UserInfo userInfo=new UserInfo();
        ThreadA a=new ThreadA(service,userInfo);
        a.setName("A");

        Thread.sleep(50);
        ThreadB b=new ThreadB(service,userInfo);
        b.setName("B");

        a.start();
        b.start();
    }
}
