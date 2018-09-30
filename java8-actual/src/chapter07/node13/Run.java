package chapter07.node13;

import chapter07.node12.ParallelStreams;

import java.util.stream.LongStream;

import static chapter07.node12.Run.measureSumPerf;

/**
 * @author : jennie
 * @date: 2018/9/28
 * @Time: 下午6:03
 */
public class Run {

    public static long sideEffectSum(long n){
        Accumulator accumulator=new Accumulator();
        LongStream.rangeClosed(1,n).parallel()
                .forEach(accumulator::add);
        return accumulator.total;
    }


    public static void main(String[] args) {
        System.out.println("sideEffectSum sum done in: "+measureSumPerf(Run::sideEffectSum,10000000)+" msecs");

    }


}
