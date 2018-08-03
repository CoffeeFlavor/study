package chapter02.node02.point07.T9;

/**
 * @author : jennie
 * @date: 2018/7/15
 * @Time: 15:39
 */
public class MyService {

    public MyOneList addServiceMethod(MyOneList list,String data){
        try {
            synchronized (this){
                if (list.getSize()<1){
                    Thread.sleep(2000);
                    list.add(data);
                }
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return list;
    }
}
