package chapter03.node01.point03;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 11:04
 */
public class Test1 {

    public static void main(String[] args) {
        try {
            String newString=new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
