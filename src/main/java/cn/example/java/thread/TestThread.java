package cn.example.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020-04-16 16:16
 */
public class TestThread {

    /**
     * 线程执行顺序
     */

    static Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " 线程1"));
    static Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " 线程2"));
    static Thread t3 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " 线程3"));


    /**
     * 方式1
     *
     * @throws InterruptedException
     */
    public static void fun1() throws InterruptedException {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }

    /**
     * 方式2
     * 单线程-线程池
     * submit 和 execute 区别
     *
     *
     */
    public static void fun2() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        fun2();
    }
}
