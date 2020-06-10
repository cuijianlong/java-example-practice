package top.lstech.thread.concurrent;

import java.util.concurrent.TimeUnit;

public class Daemon {
    /**
     * 守护进程 完成支持性工作，虚拟机退出， daemon进程的finally块不一定会执行
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
