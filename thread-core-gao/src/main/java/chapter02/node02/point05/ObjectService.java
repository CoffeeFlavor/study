package chapter02.node02.point05;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:57
 */
public class ObjectService {

    public void serviceMethodA(){
        try {
            synchronized (this){
                System.out.println("A begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end  time="+System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void serviceMethodB(){
            synchronized (this){
                System.out.println("B begin time="+System.currentTimeMillis());
                System.out.println("B end  time="+System.currentTimeMillis());
            }
    }
}
