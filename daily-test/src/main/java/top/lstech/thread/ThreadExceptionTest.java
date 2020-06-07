package top.lstech.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @Author: 义云
 * @Created: 2020/5/23 17:13
 */
public class ThreadExceptionTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService execute = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        execute.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "=====11=======");
            }
        });

        TimeUnit.SECONDS.sleep(3);


        execute.execute(new Run1());

        TimeUnit.SECONDS.sleep(3);

        execute.execute(new Run2());
        execute.shutdown();

    }

    public static class Run1 implements Runnable {

        @Override
        public void run() {
            int count = 0;
            while (true) {
                count++;
                System.out.println(Thread.currentThread().getName() + "-------222-------------" + count);

                if (count == 10) {
                    System.out.println(1 / 0);
                    try {
                    } catch (Exception e) {
                        System.out.println("Exception" + e);
                    }
                }

                if (count == 20) {
                    System.out.println("count= " + count);
                    break;
                }
            }
        }
    }

    public static class Run2 implements Runnable {
        public Run2() {
            System.out.println("run2 构造函数");
        }

        @Override
        public void run() {
            System.out.println( Thread.currentThread().getName() + "run222222222");
        }
    }
}
