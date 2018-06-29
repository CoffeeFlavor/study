package chapter05.node21;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/6/29
 * @Time: 11:54
 */
public class Run {
    public static void main(String[] args) {
        List<Dish> menu=Dish.getMemu();
        List<String> dishNames=menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<String> words=Arrays.asList("Java 8","Lambdas","In","Action");
        List<Integer> wordLengths=words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        List<Integer> dishNameLength=menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNameLength);
    }
}
