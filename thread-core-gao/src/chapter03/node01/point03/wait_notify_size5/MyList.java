package chapter03.node01.point03.wait_notify_size5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:39
 */
public class MyList {

    private static List list=new ArrayList();

    public static void add(){
        list.add("anyString");
    }

    public static int size(){
        return  list.size();
    }
}
