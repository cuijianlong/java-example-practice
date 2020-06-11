package top.lstech.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: 义云
 * @Date: 2020/6/11 9:00 PM
 * @Version 1.0
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(30);
    private static Semaphore s = new Semaphore(10);

    /**
     * semaphore 信号量
     * 控制同时访问特定资源的线程数量
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i=0;i< THREAD_COUNT; i++){
            threadPool.execute(()->{
                try {
                    s.acquire();
                    System.out.println("save data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
}
