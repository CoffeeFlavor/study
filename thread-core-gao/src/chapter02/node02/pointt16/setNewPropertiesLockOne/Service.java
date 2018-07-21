package chapter02.node02.pointt16.setNewPropertiesLockOne;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 14:26
 */
public class Service {


    public void serviceMethodA(UserInfo userInfo){
        try {
            synchronized (userInfo){
                System.out.println(
                        Thread.currentThread().getName() );
                userInfo.setUsername("adbsdcdf");
                Thread.sleep(2000);
                System.out.println("end! time="+System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
