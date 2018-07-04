package chapter05.node61;

import chapter04.Dish;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/7/2
 * @Time: 11:19
 */
public class Run {
    public static void main(String[] args) {
        List<Dish> menu=Dish.getMemu();
        int calories=menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);

       menu.stream()
                .mapToInt(Dish::getCalories)
                .average().ifPresent(System.out::println);

       menu.stream()
               .mapToInt( Dish::getCalories)
               .min().ifPresent(System.out::println);

       menu.stream().mapToInt(Dish::getCalories)
               .max().ifPresent(System.out::println);


        IntStream intStream=menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream=intStream.boxed();



    }
}
