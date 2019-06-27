package demo;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : seven
 * date: 11/03/2019
 * time: 11:01
 * 谷歌
 */
public class TestGoogleFutures {

    //线程池中线程个数
    private static final int POOL_SIZE = 50;
    //带有回调机制的线程池
    private static final ListeningExecutorService service = MoreExecutors
            .listeningDecorator(Executors.newFixedThreadPool(POOL_SIZE));

    private static Logger LOG = LoggerFactory.getLogger(TestGoogleFutures.class);

    @Test
    public void testListenableFuture() {
        try {
            testCompletableFuture();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("真的结束了");
    }

    //    @Test
    public void testCompletableFuture() throws Exception {
        // case1: supplyAsync
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            LOG.info("Run supplyAsync.");
//            return "Return result of Supply Async";
//        });
//
//        // case2: thenRun，与supplyAsync同线程
//        future.thenRun(new Runnable() {
//
//            @Override
//            public void run() {
//                LOG.info("Run action.");
//            }
//        });
//
//        // case2: thenRunAsync，另启动线程执行
//        future.thenRunAsync(new Runnable() {
//
//            @Override
//            public void run() {
//                LOG.info("Run async action.");
//            }
//        });
//
//        // 主动触发Complete结束方法
//        // future.complete("Manual complete value.");
//        future.whenComplete((v, e) -> {
//            LOG.info("WhenComplete value: " + v);
//            LOG.info("WhenComplete exception: " + e);
//        });
//        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
//            LOG.info("Return result of Run Async.");
//        });
//
//        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
//            return "hello";
//        });
//        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
//            return "world";
//        });
//        CompletableFuture<String> f = future3.thenCombine(future4,
//                (x, y) -> x + "-" + y);
//        LOG.info(f.get());


        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(5);
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        List<CompletableFuture<Integer>> removeFutures = new ArrayList<>();
        for (int j = 0; j < 20; j++) {
            final Integer index = j;
            try {
                blockingQueue.put(index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("你好，我是异步线程" + index);

                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return index;
            });
            futures.add(future);
            future.whenComplete((s, throwable) -> {
                System.out.println(s);
                blockingQueue.remove(s);
                removeFutures.add(future);
            });
        }
        futures.removeAll(removeFutures);
        System.out.println(futures.size());

        for (CompletableFuture<Integer> future : futures) {
            future.get();
        }
        System.out.println("结束了");
    }
}
