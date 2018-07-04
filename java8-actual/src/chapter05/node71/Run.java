package chapter05.node71;

import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/7/2
 * @Time: 14:43
 */
public class Run {
    public static void main(String[] args) {
        Stream<String> stream=Stream.of("Java8","Lambdas","In","Action");
        stream.map(String::toUpperCase)
                .forEach(System.out::println);
        Stream<String> emptyStream=Stream.empty();

    }
}
