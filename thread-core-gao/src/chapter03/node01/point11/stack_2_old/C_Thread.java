package chapter03.node01.point11.stack_2_old;

/**
 * @author : jennie
 * @date: 2018/8/12
 * @Time: 16:00
 */
public class C_Thread extends Thread {

    private C c;

    public C_Thread(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true){
            c.popService();
        }
    }
}
