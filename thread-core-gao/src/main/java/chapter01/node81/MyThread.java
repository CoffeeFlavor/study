package chapter01.node81;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 15:14
 */
public class MyThread extends Thread {

    private long i=0;

    public long getI(){
        return this.i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true){
            i++;
//            System.out.println(i);
        }
    }
}
