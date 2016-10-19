package org.crazyit.app.action;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: jennie
 * Date: 2016/10/11
 * Time: 17:37
 */
public class Test {

    protected static long count = 0;
    public void add(long value){
        count = count + value;
    }

    public static void main(String[] args) {
//       final Test  test=new Test();

        Thread thread=new Thread(){
            @Override
            public void run() {
               new  Test().add(2);
                System.out.println( new  Test().count);
            }
        };
        thread.start();
        Thread thread2=new Thread(){
            @Override
            public void run() {
                new  Test().add(3);
            }
        };
        thread2.start();

        try {
            new Thread(){
                @Override
                public void run() {
                    System.out.println( new  Test().count);

                }
            }.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
