package com.imooc.concurrent;

import sun.reflect.generics.tree.VoidDescriptor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: jennie
 * Date: 2017/5/14
 * Time: 16:24
 */
public class Data {

    private  int data;

    private ReadWriteLock lock=new ReentrantReadWriteLock();

    public  void set(int data){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"准备写入数据");
            try {
                Thread.sleep(20);
                this.data=data;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.writeLock().unlock();
        }
        System.out.println(Thread.currentThread().getName()+"写入"+this.data);
    }

    public  void get(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"准备读取数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读取"+this.data);
        } finally {
            lock.readLock().lock();
        }
    }
}
