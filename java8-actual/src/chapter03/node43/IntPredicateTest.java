package chapter03.node43;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author : jennie
 * @date: 2018/6/26
 * @Time: 14:39
 */
public class IntPredicateTest {
    public static void main(String[] args) {
        IntPredicate evenNumbrs=(int i)->i/2==0;
        evenNumbrs.test(1000);
        Predicate<Integer> oddNumber=(Integer i)->i/2==1;
        oddNumber.test(10000);
    }
}
