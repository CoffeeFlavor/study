package chapter03.node81;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/6/27
 * @Time: 17:26
 */
public class Run {
    public static void main(String[] args) {
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
        List<Apple> inventory = new ArrayList<>();
        inventory.sort(c);
        inventory.sort(c.reversed());
        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
        .thenComparing(Apple::getCountry));


    }
}
