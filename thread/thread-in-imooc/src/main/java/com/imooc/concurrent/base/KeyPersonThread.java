package com.imooc.concurrent.base;

/**
 * User: jennie
 * Date: 2016/7/6
 * Time: 10:49
 */
public class KeyPersonThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始了战斗！");
        for (int i=0;i<10;i++ ){
            System.out.println(Thread.currentThread().getName()+"左突右击，攻击隋军...");
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗！");

    }
}
