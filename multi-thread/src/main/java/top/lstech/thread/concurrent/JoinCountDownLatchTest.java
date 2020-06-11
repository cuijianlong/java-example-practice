package top.lstech.thread.concurrent;

/**
 * @Author: 义云
 * @Date: 2020/6/11 8:39 PM
 * @Version 1.0
 */
public class JoinCountDownLatchTest {
    static Thread t1 = new Thread(() -> {
        System.out.println("1");
    });
    static Thread t2 = new Thread(()-> {
        System.out.println("2");
    });

    /**
     * 主线程等待所有的线程执行完成
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        t1.start();;
        t2.start();;
        t1.join();
        t2.join();
    }
}
