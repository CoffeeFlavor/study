package chapter03.node01.point11.stack_2_old;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/8/12
 * @Time: 11:41
 */
public class MyStack {

    private List list=new ArrayList();

    synchronized public void push(){
        try {
            if (list.size()==1){
                this.wait();
            }
            list.add("anyThing="+Math.random());
            this.notify();
            System.out.println("push="+list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public String pop(){
        String returnValue="";
        try {
            if (list.size()==0){
                System.out.println("pop 操作中的："+Thread.currentThread().getName()+" 线程呈wait 状态");
                this.wait();
            }
            returnValue=""+list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop="+list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return returnValue;
    }
}
