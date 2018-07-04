package chapter06.node24;

import chapter04.Dish;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.lang.reflect.Member;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/7/4
 * @Time: 10:13
 */
public class Run {

    public static void main(String[] args) {
        List<Dish> menu=Dish.getMemu();
//        int totalCalories=menu.stream().collect(Collectors.reducing(0,Dish::getCalories,(i, j) ->i+j ));
//        int totalCalories=menu.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum));
        int totalCalories=menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories);
//        Long count=menu.stream().reduce(0,e->1L,Long::sum);

//        Optional<Dish> mostCalorieDish=menu.stream().collect(Collectors.reducing((o, o2) -> o.getCalories()>o2.getCalories()?o:o2));
        Optional<Dish> mostCalorieDish=menu.stream().reduce((o, o2) -> o.getCalories()>o2.getCalories()?o:o2);
        System.out.println(mostCalorieDish.orElse(new Dish("a",false,0,Dish.Type.MEAR)));

        Stream<Integer> stream=Stream.of(1,2,3,4,5,6);
        List<Integer> numbers=stream.reduce(new ArrayList<Integer>(),(List<Integer> l,Integer e) ->{l.add(e);return l;},
                (List<Integer> l1,List<Integer> l2)->{l1.addAll(l2);return  l1;});

        System.out.println(numbers);

//        Optional<Integer> accResult=Stream.of(1,2,3,4)
//                .reduce((acc, item) -> {
//                    System.out.println("acc: "+acc);
//                    acc+=item;
//                    System.out.println("item: "+item);
//                    System.out.println("acc: "+acc);
//                    System.out.println("-------------");
//                    return acc;
//                });

//        int accResult2=Stream.of(1,2,3,4)
//                .reduce(0,(acc, item) -> {
//                    System.out.println("acc: "+acc);
//                    acc+=item;
//                    System.out.println("item: "+item);
//                    System.out.println("acc: "+acc);
//                    System.out.println("-------------");
//                    return acc;
//                });
//        System.out.println(accResult2);

//        ArrayList<Integer> accResult_=Stream.of(1,2,3,4,5)
//                .reduce(new ArrayList<Integer>(),
//                        new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
//                            @Override
//                            public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {
//                                acc.add(item);
//                                System.out.println("item: " + item);
//                                System.out.println("acc: " + acc);
//                                System.out.println("BiFunction");
//                                return acc;
//                            }
//                        },
//                        new BinaryOperator<ArrayList<Integer>>() {
//                            @Override
//                            public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
//                                System.out.println("BinaryOperator");
//                                acc.addAll(item);
//                                System.out.println("item: " + item);
//                                System.out.println("acc: " + acc);
//                                System.out.println("- - - - - - ");
//                                return acc;
//                            }
//                        }
//                );
//        System.out.println("accResult_: "+accResult_);

      Integer wer=  Stream.of(1,2,3,4,5)
                .reduce(0, new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer acc, Integer item) {
                        acc =1;
                        System.out.println("item: " + item);
                        System.out.println("acc: " + acc);
                        System.out.println("BiFunction");
                        return acc;
                    }
                }, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer acc, Integer item) {
                        acc += item;
                        System.out.println("item: " + item);
                        System.out.println("acc: " + acc);
                        System.out.println("BinaryOperator");
                        return acc;
                    }
                });

      Collectors.counting();
        System.out.println(wer);

        String shortMenu=menu.stream().collect(Collectors.reducing("",Dish::getName,(s, s2) -> s+","+s2));
        System.out.println(shortMenu);
    }
}
