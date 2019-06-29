package chapter02.node03.point03;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 15:52
 */
public class Run {

    public static void main(String[] args) {
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println(" 已赋值为false");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
