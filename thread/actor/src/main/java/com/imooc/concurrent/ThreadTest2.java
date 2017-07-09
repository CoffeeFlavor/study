package com.imooc.concurrent;

import com.sun.corba.se.impl.orbutil.ORBUtility;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.org.apache.xpath.internal.functions.FuncBoolean;
import com.sun.xml.internal.ws.api.pipe.TransportTubeFactory;

import java.nio.channels.NotYetBoundException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: jennie
 * Date: 2017/5/14
 * Time: 16:57
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        final Bussiness bussiness=new Bussiness();
        new Thread(new Runnable() {
            public void run() {
                threadExecute(bussiness,"sub");
            }
        }).start();
        threadExecute(bussiness,"main");
    }
    public static  void  threadExecute(Bussiness bussiness,String threadType){
        for (int i = 0; i < 100; i++) {
            try {
                if (threadType.equals("main")) {
                    bussiness.main(i);
                }else {
                    bussiness.sub(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Bussiness {
    private boolean bool = true;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void main(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (bool) {
                condition.await();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("main thread seq of " + i + ",loop of " + loop);
            }
            bool = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void sub(int loop) throws InterruptedException {
        lock.lock();
        try {

            while (!bool) {
                condition.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("sub thread seq of " + i + ",loop of" + loop);
            }
            bool = false;
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

    class BoundBuffer{
        final Lock lock=new ReentrantLock();
        final Condition notFull=lock.newCondition();
        final Condition notEmpty=lock.newCondition();
        final Object[] items=new Object[100];

        int putptr,takeptr,count;
        public void put(Object x) throws InterruptedException{
            lock.lock();
            try {
                while (count==items.length){
                    notFull.await();
                }
                items[putptr]=x;
                if (++putptr==items.length)  putptr=0;
                ++count;
                notFull.signal();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException{
            lock.lock();
            try {
                while (count==0)
                    notEmpty.await();
                Object x=items[takeptr];
                if (++takeptr==items.length) takeptr=0;
                --count;
                notFull.signal();
                return x;
            }finally {
                lock.unlock();
            }
        }
    }
}
