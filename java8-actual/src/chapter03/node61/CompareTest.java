package chapter03.node61;

import java.util.Arrays;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/6/26
 * @Time: 15:17
 */
public class CompareTest {
    public static void main(String[] args) {
        List<String> str=Arrays.asList("a","b","A","B");
//        str.sort((o1, o2) -> o1.compareToIgnoreCase(o2));
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);
    }
}
