package chapter02.node02.point07.sync_Out_asyn;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 15:33
 */
public class Run {
    public static void main(String[] args) {
        MyList myList=new MyList();
        MyThreadA a=new MyThreadA(myList);
        a.setName("A");
        a.start();
        MyThreadB b=new MyThreadB(myList);
        b.setName("B");
        b.start();
    }
}
