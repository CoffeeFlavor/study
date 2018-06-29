package chapter04.node20;

import chapter04.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/6/28
 * @Time: 15:18
 */
public class Run {
    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames=Dish.getMemu()
                .stream().filter(dish -> dish.getCalories()>300)
                .map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);
    }
}
