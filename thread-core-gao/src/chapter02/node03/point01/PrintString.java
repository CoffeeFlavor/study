package chapter02.node03.point01;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 15:16
 */
public class PrintString {

    private boolean isContinuePrint=true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod(){
        try {
            while (isContinuePrint==true){
                System.out.println(" run printStringMethod threadName= "+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
