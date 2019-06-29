package chapter02.node03.point02;
/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 15:18
 */
public class Run {

    public static void main(String[] args) {
        PrintString printStringService=new PrintString();
        new Thread(printStringService).start();
        System.out.println(" 我要停止它！ stopThread="
        +Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }
}
