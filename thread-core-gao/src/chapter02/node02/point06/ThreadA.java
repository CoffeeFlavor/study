package chapter02.node02.point06;

/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:59
 */
public class ThreadA extends Thread {


    private Task task;

    public ThreadA(Task task){
        this.task =task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}