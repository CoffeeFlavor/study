package chapter07.node12;

import java.util.function.UnaryOperator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/9/25
 * @Time: 下午3:28
 */
public class ParallelStreams {

    public static long sequentialSum(long n){
        return Stream.iterate(1L, i->i+1)
                .limit(n)
                .reduce(0L,Long::sum);

    }


    public static long iterativeSum(long n){

        long result=0;
        for (long i = 1L; i <=n; i++) {
            result+=i;
        }
        return result;
    }


    public static long parallelSum(long n){
        return Stream.iterate(1L,i->i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }


    public static long rangeSum(long n){
        return LongStream.rangeClosed(1,n)
                .reduce(0L,Long::sum);
    }


    public static long parallelRangeSum(long n){
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(0L,Long::sum);
    }


}
