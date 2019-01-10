package chapter02.node01.point02;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:10
 */
public class ThreadA extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef){
        super();
        this.numRef=numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
