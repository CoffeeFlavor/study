package chapter04.node41;

import chapter04.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/6/29
 * @Time: 9:39
 */
public class Run {
    public static void main(String[] args) {
        List<Dish> menu=Dish.getMemu();
        List<String> names=menu.stream()
                .filter(dish -> {
                    System.out.println("filtering "+dish.getName());
                    return dish.getCalories()>300;
                })
                .map(dish -> {
                    System.out.println("mapping "+dish.getName());
                    return dish.getName();
                })
                .limit(3
                )
                .collect(Collectors.toList());
        System.out.println(names);
       long count=  menu.stream()
                .filter(dish -> {
                    System.out.println("filtering "+dish.getName());
                    return dish.getCalories()>300;
                })
                .map(dish -> {
                    System.out.println("mapping "+dish.getName());
                    return dish.getName();
                }).count();
        System.out.println(count);
    }
}
