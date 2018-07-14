package chapter02.node01.point05;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:13
 */
public class Run {

    public static void main(String[] args) {

        try {
            PublicVar publicVar=new PublicVar();
            ThreadA thread=new ThreadA(publicVar);
            thread.start();
            Thread.sleep(200);
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
