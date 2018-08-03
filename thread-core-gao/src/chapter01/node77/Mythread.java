package chapter01.node77;

import chapter01.node75.MyThread;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 14:35
 */
public class Mythread extends Thread {

    private SynchronizedObject object;



    public Mythread(SynchronizedObject object){
        super();
        this.object=object;
    }

    @Override
    public void run() {
        object.printString("b","bb");

    }
}
