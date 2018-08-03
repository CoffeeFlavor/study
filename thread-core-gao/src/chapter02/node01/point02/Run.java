package chapter02.node01.point02;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:14
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef=new HasSelfPrivateNum();
        ThreadA threadA=new ThreadA(numRef);
        threadA.start();

        ThreadB threadB=new ThreadB(numRef);
        threadB.start();
    }
}
