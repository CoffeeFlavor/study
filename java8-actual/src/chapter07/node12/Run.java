package chapter07.node12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author : jennie
 * @date: 2018/9/5
 * @Time: 18:16
 */
public class Run {

    public long measureSumPerf(Function<Long,Long> adder,long n){
        long fastest=Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long start=System.nanoTime();
            long sum=adder.apply(n);
            long duration=(System.nanoTime()-start)/100000;
            System.out.println("Result: "+sum);
            if (duration<fastest){fastest=duration;}
        }
        return fastest;
    }

    private static ConcurrentHashMap<String,List<String>> concurrentHashMap=new ConcurrentHashMap<>();

    public static void main(String[] args) {
        String key="ab";
        List<String> list=new ArrayList<>();
        list.add("adb");
        concurrentHashMap.put(key,list);

        List<String> olderList=concurrentHashMap.get(key);
        if (olderList==null){
            olderList=new ArrayList<>();
        }
        List<String> newList=new ArrayList<>(olderList);
        newList.add("cnd");

        System.out.println(olderList.hashCode());
        List<String> list1=new ArrayList<>();
        list1.add("哈哈");
        System.out.println(list1.hashCode());


//        concurrentHashMap.put(key,list1);
        if (concurrentHashMap.replace(key,list1,newList)){
            System.out.println("添加成功");
        }else {
            System.out.println("没有改变");
        }
    }
}
