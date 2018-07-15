package chapter02.node02.point07.sync_Out_asyn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 15:20
 */
public class MyList {

    private List list=new ArrayList();

    synchronized public void add(String username){
        System.out.println("ThreadName="+Thread.currentThread().getName()+"执行了 add 方法！");
        list.add(username);
        System.out.println("ThreadName="+Thread.currentThread().getName()+"退出了 add 方法！");
    }

    synchronized public int getSize(){
        System.out.println("ThreadName="+Thread.currentThread().getName()+"执行了 getSize 方法！");
        int sizeValue=list.size();
        System.out.println("ThreadName="+Thread.currentThread().getName()+"退出了 getSize 方法！");
        return sizeValue;
    }
}
