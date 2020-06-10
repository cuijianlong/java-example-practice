package top.lstech.thread.concurrent;

import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Deprecated {

    /**
     *  创建一个PrintThread 1秒的频率打印数据
     *  主线程可以对其进行 暂停，恢复，停止的操作
     *  suspend()
     *  resume()
     *  stop()
     *
     *  容易导致死锁，占用资源不释放
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");

        Thread printThread = new Thread(new PrintRunner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        // 暂停线程
        printThread.suspend();
        System.out.println("暂停: " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        // 恢复线程
        printThread.resume();
        System.out.println("恢复：" + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        // 停止线程
        printThread.stop();
        System.out.println("停止：" + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static class PrintRunner implements Runnable{
        @SneakyThrows
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName() + "Run at" + format.format(new Date()));
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

}
