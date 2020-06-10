package top.lstech.thread.concurrent;

import java.util.concurrent.TimeUnit;

public class Shutdown {

    /**
     * 安全的终止一个线程
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread countThread = new Thread(new Runner(), "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

//        Runnable two = new Runner();
//        countThread = new Thread(two, "CountThread");
//        countThread.start();
//        TimeUnit.SECONDS.sleep(1);
        TimeUnit.SECONDS.sleep(2);
    }
    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("i+" + i);
        }
        public void cancel(){
            on = false;
        }
    }
}
