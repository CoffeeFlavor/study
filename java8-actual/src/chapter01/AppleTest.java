package chapter01;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/6/4
 * @Time: 10:48
 */
public class AppleTest {
    public static void main(String[] args) {
        Comparator<Apple> byWeght=new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        };
        List<Apple> apples=new ArrayList<>();
        apples.sort(byWeght);

        Runnable r1=() -> System.out.println("Hello World");

        Runnable r2=new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };
        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World 3"));
        process(() -> System.out.println("This is awesome"));

    }

    public static void process (Runnable r){
        r.run();
    }

}
