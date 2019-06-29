package chapter03.node01.point03;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 11:07
 */
public class Test2 {

    public static void main(String[] args) {

        try {
            String lock=new String();
            System.out.println(" syn 上面");
            synchronized (lock){
                System.out.println(" syn 第一行");
                lock.wait();
                System.out.println(" wait 下的代码！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
