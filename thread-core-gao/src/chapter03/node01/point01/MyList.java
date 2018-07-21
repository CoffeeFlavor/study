package chapter03.node01.point01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:39
 */
public class MyList {

    private List list=new ArrayList();

    public void add(){
        list.add("高洪松");
    }

    public int size(){
        return  list.size();
    }
}
