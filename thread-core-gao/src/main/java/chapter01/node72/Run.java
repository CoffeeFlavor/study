package chapter01.node72;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:22
 */
public class Run {
    public static void main(String[] args) {
        try {
            Mythread mythread=new Mythread();
            mythread.start();
            Thread.sleep(1000);
            mythread.interrupt();
            System.out.println("是否停止1？="+mythread.interrupted());
            System.out.println("是否停止2？="+mythread.interrupted());
        }catch (InterruptedException  e){
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
