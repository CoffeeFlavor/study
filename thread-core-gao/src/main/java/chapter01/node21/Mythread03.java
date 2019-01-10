package chapter01.node21;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 11:30
 */
public class Mythread03 extends Thread{

    private int i;

    public Mythread03(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
