package chapter02.node02.point04;


/**
 * @author : jennie
 * @date: 2018/7/14
 * @Time: 17:59
 */
public class ThreadB extends Thread {

    private Task task;

    public ThreadB(Task task){
        this.task =task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
