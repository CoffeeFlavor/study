package chapter03.node01.point11.p_r_test;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:49
 */
public class Run {
    public static void main(String[] args) {
        String lock=new String("");

        P p=new P(lock);
        C c=new C(lock);
        ThreadP threadP=new ThreadP(p);

        ThreadC threadC=new ThreadC(c);
        threadP.start();
        threadC.start();
    }
}
