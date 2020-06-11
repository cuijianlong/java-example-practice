package top.lstech.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: 义云
 * @Date: 2020/6/11 8:42 PM
 * @Version 1.0
 */
public class CountDownLatchTest {

    private static CountDownLatch c = new CountDownLatch(2);

    static Thread t1 = new Thread(() -> {
        System.out.println(1);
    });

    static Thread t2 = new Thread(() -> {
        System.out.println(2);
    });

    static Thread t3 = new Thread(() -> {
        System.out.println(3);
    });

    /**
     * 使用 CountDownLatch 实现类似 join 的功能;
     *
     * @param args
     */
    public static void main(String[] args) {
        t1.start();
        c.countDown();

        t2.start();
        c.countDown();
        t3.start();
    }
}
