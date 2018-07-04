package chapter06.node32;

import chapter04.Dish;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/7/4
 * @Time: 15:35
 */
public class Run {
    public static void main(String[] args) {
        List<Dish> menu=Dish.getMemu();
        Map<Dish.Type,Long> typeCount=menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));
        System.out.println(typeCount);
        Map<Dish.Type,Optional<Dish>> mostCaloricByType=menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        Map<Dish.Type,Dish> mostCaloricByType2=menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)));
        System.out.println(mostCaloricByType2);

//        Map<Dish.Type,Dish> mostCaloricByType3=menu.stream()
//                .collect(Collectors.toMap(Dish::getType,dish -> ));
//        System.out.println(mostCaloricByType3);

        Map<Dish.Type,Integer> totalCaloricByType=menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.summingInt(Dish::getCalories)));
        System.out.println(totalCaloricByType);

        Map<Dish.Type,Set<Dish.CaloriceLevel>> caloricLevelsByType=menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.mapping(
                        dish->{
                            if (dish.getCalories()<=400){
                                return Dish.CaloriceLevel.DIET;
                            }else if (dish.getCalories()<=700){
                                return Dish.CaloriceLevel.NORMAL;
                            }else {
                                return Dish.CaloriceLevel.FAT;
                            }
                },Collectors.toSet())));

        System.out.println(caloricLevelsByType);
    }
}
