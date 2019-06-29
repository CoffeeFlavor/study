package chapter02.node01.point05;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:11
 */
public class ThreadA extends Thread {
    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar){
        this.publicVar=publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }
}
