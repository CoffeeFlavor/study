package chapter05.node74;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/7/2
 * @Time: 15:03
 */
public class Run {

    public static void main(String[] args) {
        Stream.iterate(0,n->n+2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0,1},ints -> new int[]{ints[1],ints[0]+ints[1]})
                .limit(20)
                .forEach(t -> System.out.println(t[0]+","+t[1]) );

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntSupplier fib=new IntSupplier() {
            private int previous=0;
            private int current=1;
            @Override
            public int getAsInt() {
                int oldPrevious=this.previous;
                int nextValue=this.previous+this.current;
                this.previous=this.current;
                this.current=nextValue;
                return oldPrevious;
            }
        };

        IntStream.generate(fib).limit(10)
                .forEach(System.out::println);


    }
}
