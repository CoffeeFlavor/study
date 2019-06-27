package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : seven
 * date: 08/03/2019
 * time: 19:28
 */
public class NettyTest {
    public static void main(String[] args) {

        //实现一个Callable接口
        Callable<Netty> c = new Callable<Netty>() {

            @Override
            public Netty call() throws Exception {

                //这里是你的业务逻辑处理

                //让当前线程阻塞1秒看下效果
                Thread.sleep(1000);
                return new Netty("张三");
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(10);

        //记得要用submit，执行Callable对象
        List<Future<Netty>> futures = new ArrayList<>();

        //一定要调用这个方法，不然executorService.isTerminated()永远不为true
        for (int i = 0; i < 5; i++) {
            futures.add(es.submit(c));
        }
        es.shutdown();

        //无限循环等待任务处理完毕  如果已经处理完毕 isDone返回true

        while (true) {
            List<Future<Netty>> removeFutures = new ArrayList<>();
            for (Future<Netty> future : futures) {
                if (future.isDone()) {

                    try {
                        Netty nt = future.get();
                        System.out.println(nt.name);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    removeFutures.add(future);
                }
            }
            futures.removeAll(removeFutures);
            if (futures.isEmpty()) {
                break;
            }

        }
    }

    static class Netty {

        private String name;

        private Netty(String name) {
            this.name = name;
        }

    }
}
