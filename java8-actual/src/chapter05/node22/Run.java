package chapter05.node22;

import chapter04.Dish;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/6/29
 * @Time: 13:48
 */
public class Run {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMemu();
        List<String> words = Arrays.asList("hello", "word");
        List<String> letters = words.stream().map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(letters);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareNumbers = numbers.stream()
                .map(x -> x * x).collect(Collectors.toList());
        System.out.println(squareNumbers);

        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<Integer[]> list = number1.stream()
                .flatMap(i -> number2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new Integer[]{i, j}))
                .collect(Collectors.toList());
        list.forEach(integers -> System.out.println(Arrays.toString(integers)));

        menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(dish -> System.out.println(dish.getName()));

        Optional<Integer> firstSquareDivisibleByTree = numbers.stream()
                .map(x -> x * x).filter(integer -> integer % 3 == 0).findFirst();
        System.out.println(firstSquareDivisibleByTree.orElse(0));;

        System.out.println(numbers.stream().reduce(0,Integer::sum));
    }
}
