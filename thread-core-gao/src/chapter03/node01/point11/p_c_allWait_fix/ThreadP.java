package chapter03.node01.point11.p_c_allWait_fix;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:47
 */
public class ThreadP extends Thread{

    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.setValued();
        }
    }
}
