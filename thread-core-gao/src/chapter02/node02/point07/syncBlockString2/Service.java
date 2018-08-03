package chapter02.node02.point07.syncBlockString2;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 12:47
 */
public class Service {

    private final String anyString=new String();

    public void a(){
        try {
            synchronized (anyString){
                System.out.println("a begin");
                Thread.sleep(3000);
                System.out.println("a end");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void b(){
        System.out.println("b begin");
        System.out.println("b end");
    }
}
