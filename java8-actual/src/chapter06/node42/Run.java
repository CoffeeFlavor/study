package chapter06.node42;

import chapter06.Dun;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : jennie
 * @date: 2018/7/27
 * @Time: 11:30
 */
public class Run {

    public static void main(String[] args) {
        Run run=new Run();
        for (int i = 1; i < 1000; i++) {
            if (run.isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    public boolean isPrime(int candidate){
        int candidateRoot=(int) Math.sqrt((double)candidate);
        return IntStream.range(2,candidateRoot)
                .noneMatch(value -> candidate%value==0);
    }


    public Map<Boolean,List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2,n).boxed()
                .collect(Collectors.partitioningBy(candidate->isPrime(candidate)));
    }
}
