package chapter03.node43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author : jennie
 * @date: 2018/6/26
 * @Time: 14:17
 */
public class FunctionTest {
    public static <T,R>List<R> map(List<T> list, Function<T,R> f){
        List<R> result=new ArrayList<>();
        for (T s:list){
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l=map(Arrays.asList("lambdas","in","activity"),String::length);
        System.out.println(l);
    }
}
