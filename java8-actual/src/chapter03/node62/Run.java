package chapter03.node62;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : jennie
 * @date: 2018/6/26
 * @Time: 15:29
 */
public class Run {
    public static void main(String[] args) {
        Supplier<Apple> c1=Apple::new;
        Apple a1=c1.get();
        Function<Integer,Apple> c2=Apple::new;
        Apple a2=c2.apply(100);
        List<Integer> weight=Arrays.asList(7,3,4,10);
        List<Apple> apples=map(weight,Apple::new);
        System.out.println(apples);
        BiFunction<String,Integer,Apple> biFunction=Apple::new;
        Apple c3=biFunction.apply("green",10);

        Fruit apple=giveMeFruit("apple",500);
        System.out.println(apple.toString());

    }

    public static List<Apple> map(List<Integer> list,Function<Integer,Apple> f){
        List<Apple> result=new ArrayList<>();
        for (Integer integer : list) {
            result.add(f.apply(integer));
        }
        return result;
    }

    static Map<String,Function<Integer,Fruit>> map=new HashMap<>();

    static {
        map.put("apple",Apple::new);
        map.put("orange",Orange::new);
    }

    public static Fruit giveMeFruit(String fruit,Integer weight){
        return map.get(fruit).apply(weight);
    }
}

