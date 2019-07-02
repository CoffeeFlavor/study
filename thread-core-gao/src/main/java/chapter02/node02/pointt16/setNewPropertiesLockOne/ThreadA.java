package chapter02.node02.pointt16.setNewPropertiesLockOne;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 14:30
 */
public class ThreadA extends Thread {

    private Service service;

    private UserInfo userInfo;


    public ThreadA(Service service, UserInfo userInfo) {
        this.service = service;
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
        service.serviceMethodA(userInfo);
    }
}