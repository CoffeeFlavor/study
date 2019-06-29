package chapter02.node02.point07.T9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 15:20
 */
public class MyOneList {

    private List list=new ArrayList();

    synchronized public void add(String data){
        list.add(data);
    }

    synchronized public int getSize(){
        return list.size();
    }
}
