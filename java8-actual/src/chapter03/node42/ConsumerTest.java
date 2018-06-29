package chapter03.node42;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : jennie
 * @date: 2018/6/25
 * @Time: 14:21
 */
public class ConsumerTest {

    public static <T>  void forEach(List<T> list, Consumer<T> c){
        for (T t : list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        forEach(Arrays.asList(1,2,3,4,6),integer -> {System.out.println(--integer);});
    }
}
