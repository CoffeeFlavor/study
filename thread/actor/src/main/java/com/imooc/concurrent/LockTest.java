package com.imooc.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: jennie
 * Date: 2017/5/14
 * Time: 15:57
 */
public class LockTest {

    public static void main(String[] args) {
        final Outputter1  output=new Outputter1();
        new Thread(new Runnable() {
            public void run() {
                output.output("zhangsan");
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                output.output("lisi");
            }
        }).start();
    }

}

class Outputter1{
    private Lock lock=new ReentrantLock();

        public void output(String name){
            lock.lock();
            try {
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
            }finally {
                lock.unlock();
            }
        }
}
