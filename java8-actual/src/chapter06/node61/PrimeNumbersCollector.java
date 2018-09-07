package chapter06.node61;

import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaClientTube;

import java.security.PublicKey;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : jennie
 * @date: 2018/9/5
 * @Time: 16:13
 */
public class PrimeNumbersCollector implements Collector<Integer,Map<Boolean,List<Integer>>,Map<Boolean,List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return ()->new HashMap<Boolean, List<Integer>>(){{
            put(true,new ArrayList<Integer>());
            put(false,new ArrayList<Integer>());
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {

        return (Map<Boolean,List<Integer>> acc,Integer candidate)->{
            acc.get(isPrime(acc.get(true),candidate))
                    .add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (booleanListMap, booleanListMap2) ->{
            booleanListMap.get(true).addAll(booleanListMap2.get(true));
            booleanListMap.get(false).addAll(booleanListMap2.get(false));
            return booleanListMap;
        } ;
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public static Boolean isPrime(List<Integer> primes,int candidate){
        int candidateRoot=(int)Math.sqrt((double) candidate);
        return takeWhile(primes,i->i<=candidateRoot)
                .stream()
                .noneMatch(p->candidate%p==0);
    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p){
        int i=0;
        for (A item : list) {
            if (p.test(item)){
                return list.subList(0,i);
            }
            i++;
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(partitionPrimesWithCustomCollector(100));
    }

    public static Map<Boolean,List<Integer>> partitionPrimesWithCustomCollector(int n){
        return IntStream.rangeClosed(2,n).boxed().collect(new PrimeNumbersCollector());
    }

}
