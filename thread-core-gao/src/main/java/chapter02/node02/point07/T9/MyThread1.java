package chapter02.node02.point07.T9;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 15:29
 */
public class MyThread1 extends Thread {

    private MyOneList list;

    public MyThread1(MyOneList list){
        super();
        this.list=list;
    }

    @Override
    public void run() {
        MyService msRef=new MyService();
        msRef.addServiceMethod(list,"A");
    }
}