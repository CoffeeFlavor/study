package chapter03.node01.point01;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:41
 */
public class ThreadA extends Thread {

    private MyList list;

    public ThreadA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了"+(i+1)+"个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
