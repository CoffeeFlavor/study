package chapter02.node02.point07.sync_Out_asyn;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 15:29
 */
public class MyThreadB extends Thread {

    private MyList list;

    public MyThreadB(MyList list){
        super();
        this.list=list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add("threadB"+(i+1));
        }
    }
}
