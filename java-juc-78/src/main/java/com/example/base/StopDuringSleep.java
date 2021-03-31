package com.example.base;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/27
 * @Version: 1.0
 * @Desc
 */
public class StopDuringSleep {

  public static void main(String[] args) throws InterruptedException {

    Runnable runnable = () -> {
      int num = 0;
      try {
        while (!Thread.currentThread().isInterrupted() && num <= 10000) {
          System.out.println(num);
          num++;
          Thread.sleep(10000000);
        }
      } catch (InterruptedException e) {
        // 即使处于休眠中的线程，也是可以感受到中断信号的
        e.printStackTrace();
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();
    Thread.sleep(5);
    thread.interrupt();
  }

}
