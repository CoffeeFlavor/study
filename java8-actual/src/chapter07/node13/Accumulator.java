package chapter07.node13;

import java.security.PublicKey;

/**
 * @author : jennie
 * @date: 2018/9/28
 * @Time: 下午6:09
 */
public class Accumulator {

    public long total=0;

    public void add(long value){
        total+=value;
    }
}
