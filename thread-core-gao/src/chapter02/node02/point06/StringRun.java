package chapter02.node02.point06;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 12:32
 */
public class StringRun {

    public static void main(String[] args) {
        String a="world";

        String b=new String("world");
        System.out.println(a==b);
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
    }
}
