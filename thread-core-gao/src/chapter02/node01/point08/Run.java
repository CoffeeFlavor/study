package chapter02.node01.point08;

/**r
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:15
 */
public class Run {

    public static void main(String[] args) {
        Sub subRef=new Sub();
        ThreadA a=new ThreadA(subRef);
        a.setName("A");
        a.start();

        ThreadB b=new ThreadB(subRef);
        b.setName("B");
        b.start();

    }
}
