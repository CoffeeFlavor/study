package chapter07.node21;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import static chapter07.node12.Run.measureSumPerf;

/**
 * @author : jennie
 * @date: 2018/9/30
 * @Time: 下午5:47
 */
public class Run {

    public static void main(String[] args) {
//        System.out.println("ForkJoin sum done in: "+measureSumPerf(ForkJoinSumCalculator::forkJoinSum,10_000_000));
        Map<String,Boolean> has=new HashMap<>();
        has.put("nihap",false);
        System.out.println(has.put("nihap",true));
        System.out.println(has.get("nihap"));
    }
}