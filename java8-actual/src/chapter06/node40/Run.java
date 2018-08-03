package chapter06.node40;

import chapter04.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

import static java.util.stream.Collectors.*;

/**
 * @author : jennie
 * @date: 2018/7/18
 * @Time: 11:35
 */
public class Run {

    public static void main(String[] args) {
        List<Dish> menu = Dish.getMemu();

        Map<Boolean, List<Dish>> partionedMenu = menu
                .stream()
                .collect(partitioningBy(Dish::isVegetarian));

        List<Dish> vegetarianDiashes=partionedMenu.get(true);

        List<Dish> vegetarianDiashes2=menu.stream().filter(Dish::isVegetarian).collect(toList());


        menu.stream().collect(partitioningBy(Dish::isVegetarian,partitioningBy(o -> o.getCalories()>500)));


        menu.stream().collect(partitioningBy(Dish::isVegetarian,counting()));


    }
}
