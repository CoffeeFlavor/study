package chapter03.node01.point03.wait_notify_size5;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:41
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
           synchronized (lock){
               if (MyList.size()!=5){
                   System.out.println(" wait begin "+System.currentTimeMillis());
                   lock.wait();
                   System.out.println("wait end "+System.currentTimeMillis());
               }
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
