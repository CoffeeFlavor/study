package chapter01.node82;

/**
 * @author : jennie
 * @date: 2018/7/8
 * @Time: 15:50
 */
public class Run {
    public static void main(String[] args) {
        try {
            final SynchronizedObject object=new SynchronizedObject();
            Thread thread1=new Thread(){
                @Override
                public void run() {
                    object.pringString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2=new Thread(){
                @Override
                public void run() {
                    System.out.println("thread2 启动了，但进入不了printString（）方法！ 只打印了1个begin" );
                    System.out.println("因为平日printString（）方法被a线程锁定并且永远suspend 暂停了");
                    object.pringString();
                }
            };
            thread2.start();
    }catch (InterruptedException  e){
        e.printStackTrace();
        }
    }
}
