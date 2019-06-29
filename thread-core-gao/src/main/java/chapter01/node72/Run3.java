package chapter01.node72;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:41
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            Mythread thread=new Mythread();
            thread.start();
            Thread.sleep(100);
            thread.interrupt();
            System.out.println("是否停止1？="+thread.isInterrupted());
            System.out.println("是否停止2？="+thread.isInterrupted());
        }catch (Exception  e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
