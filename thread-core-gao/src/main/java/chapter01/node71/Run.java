package chapter01.node71;


/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:16
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread=new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        }catch (InterruptedException  e){
            e.printStackTrace();
        }
    }
}
