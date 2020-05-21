package cn.example.test;

import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-05-21 15:29
 */
public class FutureDemo {

    /**
     * 异步执行一个计算
     *
     * @param args
     */
//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newCachedThreadPool();
//        // 启动一个线程 做计算任务
//        Future<Integer> futureResult = executor.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                int sum = 0;
//                System.out.println("开始计算 --- ");
//                for (int i = 0; i < 100; i++) {
//                    sum = sum + i;
//                }
//                Thread.sleep(TimeUnit.SECONDS.toSeconds(3));
//                System.out.println("计算结束");
//                return sum;
//            }
//        });
//
//        System.out.println("开始做其他的事情----");
//        try {
//            // 等待计算结果
//            Integer result = futureResult.get();
//            System.out.println("result: " + result);
//        } catch (Exception e) {
//            System.out.println("执行计算任务出错");
//        }
//        System.out.println("任务执行完毕");
//        executor.shutdown();
//    }

    /**
     * 线程1： 执行计算， 计算完成， 线程2: 打印计算结果
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture result = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            System.out.println(Thread.currentThread().getName() + " 开始计算 --- ");
            for (int i = 0; i < 100; i++) {
                sum = sum + i;
            }
            try {
                Thread.sleep(TimeUnit.SECONDS.toSeconds(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 计算结束");
            return sum;
        }, executorService).thenApplyAsync(sum -> {
            System.out.println(Thread.currentThread().getName() + " 打印结果: " + sum);
            return sum;
        }, executorService);
        System.out.println("开始做其他的事情----");
        try {
            System.out.println("result:" + result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("任务执行完毕");
        executorService.shutdown();
    }

}
