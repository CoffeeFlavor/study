package chapter03.node01.point10;

/**
 * @author : jennie
 * @date: 2018/7/22
 * @Time: 16:26
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock=new String("");
        Add add=new Add(lock);
        Subtract subtract=new Subtract(lock);
        ThreadSubtract subtractThread=new ThreadSubtract(subtract);
        subtractThread.setName("subtractThread");
        subtractThread.start();

        ThreadSubtract subtract2Thread=new ThreadSubtract(subtract);
        subtract2Thread.setName("subtract2Thread");
        subtract2Thread.start();

        Thread.sleep(1000);
        ThreadAdd addThread=new ThreadAdd(add);
        addThread.setName("addThread");
        addThread.start();
    }
}
