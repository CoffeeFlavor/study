package chapter03.node41;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author : jennie
 * @date: 2018/6/25
 * @Time: 14:14
 */
public class PredicateTest {

    public static <T> List<T> filter (List<T> list, Predicate<T> p) {
        List<T> results=new ArrayList<>();
        for (T s : list) {
            if (p.test(s)){
                results.add(s);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate=s -> !s.isEmpty();
        List<String> listOfStrings=new ArrayList<>();
        listOfStrings.add("");
        listOfStrings.add("ab");
        List<String> nonEmpty=filter(listOfStrings,nonEmptyStringPredicate);
        System.out.println(nonEmpty);
    }
}
