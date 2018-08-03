package chapter02.node02.point02;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:57
 */
public class ObjectService {

    public void serviceMethod(){
        try {
            synchronized (this){
                System.out.println("begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end  time="+System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
