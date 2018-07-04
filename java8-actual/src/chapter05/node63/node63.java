package chapter05.node63;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/7/2
 * @Time: 11:40
 */
public class node63 {
    public static void main(String[] args) {
      Stream<int[]> pythagoreantriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
      pythagoreantriples.limit(5)
              .forEach(t-> System.out.println(t[0]+","+t[1]+","+t[2]));

        System.out.println("=========================");
      IntStream.rangeClosed(1,100)
              .boxed()
              .flatMap(a->IntStream.rangeClosed(1,100)
                      .mapToObj(b->new double[]{a,b, Math.sqrt(a * a + b * b)})
                      .filter(t-> t[2]%1==0)
              )
//              .filter(t-> t[2]%1==0)
              .limit(5)
              .forEach(t-> System.out.println((int) t[0]+","+(int) t[1]+","+(int) t[2]));

    }
}
