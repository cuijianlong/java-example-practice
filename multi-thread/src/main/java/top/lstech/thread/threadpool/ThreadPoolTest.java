package top.lstech.thread.threadpool;

import java.util.concurrent.*;

/**
 * @Author: 义云
 * @Date: 2020/6/13 9:11 AM
 * @Version 1.0
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        /**
         * newFixedThreadPool (固定数目线程的线程池)
         * newCachedThreadPool(可缓存线程的线程池)
         * newSingleThreadExecutor(单线程的线程池)
         * newScheduledThreadPool(定时及周期执行的线程池)
         *
         */
        //ThreadPoolTest.newCachedThreadPoolTest();
        //ThreadPoolTest.newFixedThreadPoolTest();
        ThreadPoolTest.newScheduledThreadPoolTest();

    }


    /**
     * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
     * <p>
     * 缺点：一般不用，是因为newCachedThreadPool 可以无限的新建线程，容易造成堆外内存溢出，
     * 因为它的最大值是在初始化的时候设置为 Integer.MAX_VALUE，一般来说机器都没那么大内存给它不断使用。
     * 当然知道可能出问题的点，就可以去重写一个方法限制一下这个最大值。
     */
    public static void newCachedThreadPoolTest() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " " + index);
                }
            });
        }
        cachedThreadPool.shutdown();
    }

    /**
     * 定长线程池
     * 每运行一个Runnable都会通过ThreadFactory创建一个线程。
     */
    public static void newFixedThreadPoolTest() {
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " " + index);
                }
            });
        }
        cachedThreadPool.shutdown();
    }

    /**
     * 定长线程池，支持定时及周期性任务执行
     */
    public static void newScheduledThreadPoolTest() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + "");
        }, 3, TimeUnit.SECONDS);
    }
}
