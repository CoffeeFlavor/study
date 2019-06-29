package chapter02.node02.point04;

import javax.sound.midi.Soundbank;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 18:16
 */
public class Task {

    public void doLongTimeTask(){
        for (int i = 0; i < 100; i++) {
            System.out.println("no synchronized threadName="
            +Thread.currentThread().getName()+" i="+(i+1));
        }
        System.out.println(" ");
        synchronized (this){
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName="
                        +Thread.currentThread().getName()+" i="+(i+1));
            }
        }
    };
}
