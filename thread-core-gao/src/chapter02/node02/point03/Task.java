package chapter02.node02.point03;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:30
 */
public class Task {

    private String getData1;
    private String getData2;

    public  void doLongTimeTask(){
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String privateGetData1=" 长时间处理任务后从远程返回的值 1 threadName="
                    +Thread.currentThread().getName();
            String privateGetData2="长时间处理任务后从远程返回的值 2 threadName="
                    +Thread.currentThread().getName();
            synchronized (this){
                getData1=privateGetData1;
                getData2=privateGetData2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
