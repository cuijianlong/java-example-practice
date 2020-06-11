package top.lstech.thread.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: 义云
 * @Date: 2020/6/11 8:54 PM
 * @Version 1.0
 */
public class ExchangeTest {

    private static final Exchanger<String> exgr = new Exchanger<>();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);


    /**
     * 线程间交换数据
     *
     * @param args
     */
    public static void main(String[] args) {
        threadPool.execute(()->{
            String a = "a";
            try {
                exgr.exchange(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(()->{
            String b = "b";
            try {
                exgr.exchange(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
        System.out.println(exgr);
    }

}
