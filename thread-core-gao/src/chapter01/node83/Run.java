package chapter01.node83;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 11:22
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {

        final MyObject myObject=new MyObject();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                myObject.setValue("a","aa");
            }
        };
        thread1.setName("a");
        thread1.start();

        Thread thread2=new Thread(){
            @Override
            public void run() {
                myObject.printUssernamePassword();
            }
        };
        thread2.start();

    }
}
