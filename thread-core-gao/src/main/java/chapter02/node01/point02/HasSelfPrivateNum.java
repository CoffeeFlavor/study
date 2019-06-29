package chapter02.node01.point02;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 15:07
 */
public class HasSelfPrivateNum {
    private int num=0;

    public void addI(String username){
        try {
            if (username.equals("a")) {
                num=100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else {
                num=200;
                System.out.println(" b set over");
            }
            System.out.println(username+" num="+num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
