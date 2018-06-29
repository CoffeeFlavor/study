package chapter03.node92;

import java.util.function.DoubleFunction;

/**
 * @author : jennie
 * @date: 2018/6/28
 * @Time: 10:50
 */
public class Run {

    public static void main(String[] args) {

    }
    //对应数学f(x+10)dx
    public double integrate(DoubleFunction<Double> f,double a ,double b){
        return (f.apply(a)+f.apply(b))*(b-a)*1/2;
    }
}
