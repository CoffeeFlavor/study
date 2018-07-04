package chapter06.node22;

import chapter04.Dish;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/7/2
 * @Time: 18:01
 */
public class Run {
    public static void main(String[] args) {
        List<Dish> menu=Dish.getMemu();
        int totalCalories=menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        double avgCalories=menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        IntSummaryStatistics  summaryStatistics=menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(summaryStatistics.getAverage());
    }
}
