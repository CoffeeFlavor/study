package chapter02.node01.point03;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:14
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef1=new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2=new HasSelfPrivateNum();
        ThreadA threadA=new ThreadA(numRef1);
        threadA.start();

        ThreadB threadB=new ThreadB(numRef2);
        threadB.start();
    }
}
