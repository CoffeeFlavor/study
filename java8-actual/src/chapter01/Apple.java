package chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author : jennie
 * @date: 2018/6/4
 * @Time: 10:46
 */
public class Apple {

    private String color;

    private int weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result=new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result=new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight()>150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static  boolean isHeavyApple(Apple apple){
        return apple.getWeight()>150;
    }


    public List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result=new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
