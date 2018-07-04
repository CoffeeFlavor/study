package chapter06.node23;

import chapter04.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/7/4
 * @Time: 9:52
 */
public class Run {
    public static void main(String[] args) {
        List<Dish> menu=Dish.getMemu();
        String shortMenu=menu.stream()
                .map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(shortMenu);
    }
}
