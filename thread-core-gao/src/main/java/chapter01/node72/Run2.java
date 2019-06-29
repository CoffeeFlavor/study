package chapter01.node72;

/**
 * @author : jennie
 * @date: 2018/6/24
 * @Time: 15:34
 */
public class Run2 {
    public static void main(String[] args) {
            Thread.currentThread().interrupt();
            System.out.println("是否停止1？="+Thread.interrupted());
            System.out.println("是否停止2？="+Thread.interrupted());
    }
}
