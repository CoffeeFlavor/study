package chapter06.node41;

import chapter04.Dish;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author : jennie
 * @date: 2018/7/27
 * @Time: 10:48
 */
public class Run {

    public static void main(String[] args) {

//        List<Dish> menu=Dish.getMemu();
//
//        Map<Boolean,List<Dish>> partitionedMenu=menu
//                .stream()
//                .collect(partitioningBy(Dish::isVegetarian));
//        System.out.println(partitionedMenu);
//
//        List<Dish> vegetarianDishes=menu.stream().filter(Dish::isVegetarian).collect(toList());
//
//        System.out.println(vegetarianDishes);
//
//        Map<Boolean,Dish> mostCaloricPartionedByVegetarian=menu.stream()
//                .collect(
//                        Collectors.partitioningBy(Dish::isVegetarian));
//        menu.stream()
//                .collect(
//                        partitioningBy(Dish::isVegetarian,collectingAndThen(maxBy(Dish::getType))),Optional::get);
//        menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
    }
}
