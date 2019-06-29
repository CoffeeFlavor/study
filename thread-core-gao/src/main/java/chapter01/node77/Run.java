package chapter01.node77;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 14:39
 */
public class Run {
    public static void main(String[] args) {
        try {
            SynchronizedObject object=new SynchronizedObject();
            Mythread thread=new Mythread(object);
            thread.start();
            Thread.sleep(500);
            System.out.println(object.getUsername()+" "+object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
