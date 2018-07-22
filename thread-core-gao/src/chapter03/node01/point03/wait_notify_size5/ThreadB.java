package chapter03.node01.point03.wait_notify_size5;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:41
 */
public class ThreadB extends Thread {


    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {

            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        lock.notify();
                        System.out.println(" 已发出通知 ！");
                    }
                    System.out.println(" 添加了 " + (i + 1) + " 2个元素！");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}