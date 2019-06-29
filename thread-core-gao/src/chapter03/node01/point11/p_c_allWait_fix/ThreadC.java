package chapter03.node01.point11.p_c_allWait_fix;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:48
 */
public class ThreadC extends Thread {

    private C r;

    public ThreadC(C r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true){
            r.getValue();
        }
    }
}
