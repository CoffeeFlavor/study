package chapter05.node62;

import java.util.stream.IntStream;

/**
 * @author : jennie
 * @date: 2018/7/2
 * @Time: 11:28
 */
public class Run {
    public static void main(String[] args) {
        IntStream evenNumbers=IntStream.range(1,100)
                .filter(n->n%2==0);
        System.out.println(evenNumbers.count());
//        System.out.println(evenNumbers.min().getAsInt());
    }
}
