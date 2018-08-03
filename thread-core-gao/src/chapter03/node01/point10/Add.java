package chapter03.node01.point10;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:18
 */
public class Add {

    private  String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add(){
        synchronized (lock){
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
