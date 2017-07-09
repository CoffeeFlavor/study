package com.imooc.concurrent;

import java.util.Random;

/**
 * User: jennie
 * Date: 2017/5/14
 * Time: 16:30
 */
public class ReadWriteLocKTest {

    public static void main(String[] args) {
        final Data  data=new Data();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.set(new Random().nextInt(30));
                    }
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 5; j++) {
                         data.get();
                    }
                }
            }).start();
        }
    }
}
