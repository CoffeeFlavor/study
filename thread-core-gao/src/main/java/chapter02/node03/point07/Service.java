package chapter02.node03.point07;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:01
 */
public class Service {

    private boolean isContinueRun=true;

    public void runMethod(){
        while (isContinueRun==true){
            synchronized ("123"){

            }
        }
        System.out.println("停下来了！");
    }

    public void stopMethod(){
        isContinueRun=false;
    }
}
