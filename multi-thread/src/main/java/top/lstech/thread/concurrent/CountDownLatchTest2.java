package top.lstech.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: 义云
 * @Date: 2020/6/11 8:50 PM
 * @Version 1.0
 */
public class CountDownLatchTest2 {
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchTest2().go();
    }

    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // 依次创建3个线程,并启动
        new Thread(new Task(countDownLatch), "Thread1").start();
        new Thread(new Task(countDownLatch), "Thread2").start();
        new Thread(new Task(countDownLatch), "Thread3").start();
        countDownLatch.await();
        System.out.println("所有线程已到达,主线程开始执行" + System.currentTimeMillis());

    }

    class Task implements Runnable {
        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "已经到达" + System.currentTimeMillis());
            countDownLatch.countDown();
        }
    }
}
