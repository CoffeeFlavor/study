package chapter06.node31;

import chapter04.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/7/4
 * @Time: 15:07
 */
public class Run {
    public static void main(String[] args) {
        List<Dish> menu=Dish.getMemu();
        Map<Dish.Type,List<Dish>> dishesByType=menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<Dish.CaloriceLevel,List<Dish>> dishByCaloricLevel=menu.stream()
                .collect(Collectors.groupingBy(dish->{
                    if (dish.getCalories()<=400) {
                        return Dish.CaloriceLevel.DIET;
                    }else if (dish.getCalories()<=700){
                        return Dish.CaloriceLevel.NORMAL;
                    }else {
                        return Dish.CaloriceLevel.FAT;
                    }
                }));
        System.out.println(dishByCaloricLevel);

        Map<Dish.Type,Map<Dish.CaloriceLevel,List<Dish>>> dishByTypeCaloricLevel=
                menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.groupingBy(dish->{
                    if (dish.getCalories()<=400) {
                        return Dish.CaloriceLevel.DIET;
                    }else if (dish.getCalories()<=700){
                        return Dish.CaloriceLevel.NORMAL;
                    }else {
                        return Dish.CaloriceLevel.FAT;
                    }
                })));
        System.out.println(dishByTypeCaloricLevel);

    }
}
