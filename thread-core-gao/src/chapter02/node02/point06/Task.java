package chapter02.node02.point06;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 18:16
 */
public class Task {

    private String a="world";

    private String b="world";



//    synchronized
    public void otherMethod(){
        synchronized (a){
            System.out.println(System.identityHashCode(a));
            System.out.println("--------------------run--otherMethod");
        }
    }

    public void doLongTimeTask(){
        synchronized (b){
            System.out.println(System.identityHashCode(b));
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName="
                        +Thread.currentThread().getName()+" i="+(i+1));
            }
        }
    };
}
