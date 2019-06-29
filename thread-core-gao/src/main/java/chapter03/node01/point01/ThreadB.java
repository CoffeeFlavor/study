package chapter03.node01.point01;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 17:41
 */
public class ThreadB extends Thread {

    private MyList list;

    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
           while (true){
               if (list.size()==5){
                   System.out.println("==5,线程b要退出了！ ");
                   throw new InterruptedException();
               }
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
