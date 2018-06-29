package chapter04.node31;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/6/28
 * @Time: 15:41
 */
public class Run {
    public static void main(String[] args) {
        List<String> title=Arrays.asList("Java8","In","Action");
        Stream<String> s=title.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println);

    }
}
