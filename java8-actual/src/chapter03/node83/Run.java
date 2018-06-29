package chapter03.node83;

import java.util.function.Function;

/**
 * @author : jennie
 * @date: 2018/6/27
 * @Time: 17:37
 */
public class Run {
    public static void main(String[] args) {
        Function<Integer,Integer> f=x->x+1;
        Function<Integer,Integer> g=x->x*2;
        Function<Integer,Integer> h=f.andThen(g);
        System.out.println(h.apply(1));
        System.out.println(h.apply(2));
        System.out.println(h.apply(3));

        Function<Integer,Integer> fc=f.compose(g);
        System.out.println(fc.apply(1));
        System.out.println(fc.apply(2));
        System.out.println(fc.apply(3));

    }
}
