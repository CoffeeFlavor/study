package chapter06.node60;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : jennie
 * @date: 2018/9/5
 * @Time: 15:16
 */
public class Run {

    public Map<Boolean,List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2,n).boxed()
                .collect(Collectors.partitioningBy(candidate->isPrime(candidate)));
    }

    public boolean isPrime(int candidate){
        int candidateRoot=(int)Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2,candidateRoot)
                .noneMatch(i->candidate%i==0);
    }
}
