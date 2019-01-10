package chapter02.node02.point01;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:44
 */
public class MyThread1 extends Thread {

    private Task task;

    public MyThread1(Task task){
        super();
        this.task=task;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime1=System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1=System.currentTimeMillis();
    }
}
