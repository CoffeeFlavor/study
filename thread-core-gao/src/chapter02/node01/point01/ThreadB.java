package chapter02.node01.point01;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:10
 */
public class ThreadB extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef){
        super();
        this.numRef=numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
