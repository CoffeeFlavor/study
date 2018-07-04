package chapter05.node72;

import java.util.Arrays;

/**
 * @author : jennie
 * @date: 2018/7/2
 * @Time: 14:46
 */
public class Run {
    public static void main(String[] args) {
        int[] numbers={2,3,5,7,11,13};
        int sum=Arrays.stream(numbers).sum();
        System.out.println(sum);
    }
}
