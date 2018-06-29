package chapter01.node21;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 11:24
 */
public class Run02 {
    public static void main(String[] args) {
        try {
            MyThread02 thread=new MyThread02();
            thread.setName("myThread");
            thread.start();
            for (int i = 0; i < 10; i++) {
                int time=(int) (Math.random()*1000);
                Thread.sleep(time);
                System.out.println("main="+Thread.currentThread().getName());
            }
        }catch (InterruptedException  e){
            e.printStackTrace();
        }
    }
}
