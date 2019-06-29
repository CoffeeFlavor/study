package chapter06.node42;

import chapter04.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/7/31
 * @Time: 14:13
 */
public class Test {

    public static void main(String[] args) {
        List<Dish> menu = Dish.getMemu();

        List<Dish> dishes = menu.stream().collect(Collectors.toList());

        Set<Dish> dishSet = menu.stream().collect(Collectors.toSet());

//        Collection<Dish> dishCollection=menu.stream().collect(Collectors.toCollection(),ArrayList::new);

        long howManyDishes = menu.stream().collect(Collectors.counting());

        long totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));

        double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));

        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(","));

        Optional<Dish> fattest = menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));


        Optional<Dish> lightest = menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)));

        int totalCalories2 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));

        int howManyDishes2 = menu.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));


        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));

        Map<Dish.Type, Map<String, List<Dish>>> dishesByType2 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(Dish::getName)));
        System.out.println(dishesByType2);

        Map<Boolean,List<Dish>> vegetarianDishes=menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));

    }
}
