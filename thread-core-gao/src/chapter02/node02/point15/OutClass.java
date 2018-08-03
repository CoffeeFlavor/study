package chapter02.node02.point15;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 11:27
 */
public class OutClass {

    static class InnerClass1 {
        public void method1(InnerClass2 class2) {
            String threadName=Thread.currentThread().getName();
            synchronized (class2) {
                System.out.println(threadName+" 进入InnerClass1 类中的method1 方法");
                for (int i = 0; i < 10; i++) {
                    System.out.println(" i=" + i);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName+" 离开InnerClass1 类中的method1 方法");
            }
        }

        synchronized  void method2 () {
            String threadName=Thread.currentThread().getName();
                System.out.println(threadName+" 进入InnerClass1 类中的method2 方法");
                for (int j = 0; j < 10; j++) {
                    System.out.println(" j=" + j);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName+" 离开InnerClass1 类中的method2 方法");
        }

    }

    static class InnerClass2 {

        synchronized public void method1() {

            String threadName=Thread.currentThread().getName();

            System.out.println(threadName+" 进入InnerClass2 类中的method1 方法");

            for (int k = 0; k < 10; k++) {

                System.out.println( "k=" + k);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
