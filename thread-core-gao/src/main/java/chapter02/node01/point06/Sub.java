package chapter02.node01.point06;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 16:31
 */
public class Sub extends Main {

    synchronized public void operateSubMethod(){
        try {
            while (i>0){
                i--;
                System.out.println("sub print i="+i);
                Thread.sleep(100);
                this.operateImainMethod();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
