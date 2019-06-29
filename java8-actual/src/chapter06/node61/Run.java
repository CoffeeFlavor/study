package chapter06.node61;

import org.omg.CORBA.OMGVMCID;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author : jennie
 * @date: 2018/9/5
 * @Time: 15:40
 */
public class Run {

    public static Boolean isPrime(List<Integer> primes,int candidate){
        return primes.stream().noneMatch(i->candidate%i==0);
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


    public static Boolean isPrime2(List<Integer> primes,int candidate){
        int candidateRoot=(int)Math.sqrt((double) candidate);
        return takeWhile(primes,i->i<=candidateRoot)
                .stream()
                .noneMatch(p->candidate%p==0);
    }

}
