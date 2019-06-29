package chapter03.node01.point11.stack_1;

/**
 * @author : jennie
 * @date: 2018/8/12
 * @Time: 15:59
 */
public class P_Thread extends Thread {

    private P p;

    public P_Thread(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.pushService();
        }
    }
}
