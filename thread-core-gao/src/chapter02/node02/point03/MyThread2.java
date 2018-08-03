package chapter02.node02.point03;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:44
 */
public class MyThread2 extends Thread {

    private Task task;

    public MyThread2(Task task){
        super();
        this.task=task;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2=System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2=System.currentTimeMillis();
    }
}
