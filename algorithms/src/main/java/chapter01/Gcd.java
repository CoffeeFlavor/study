package chapter01;

/**
 * @author : jennie
 * @date: 2019/6/16
 * @Time: 11:27
 *
 * 最大公约数
 */
public class Gcd {

    public static int gcd(int p,int q){
        if (q==0) return p;
        int r=p%q;
        return gcd(q,r);
    }

    public static void main(String[] args) {
        int result=gcd(8,16);
        System.out.println(result);
    }

}
