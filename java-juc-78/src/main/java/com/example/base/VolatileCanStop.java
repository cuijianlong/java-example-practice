package com.example.base;

/**
 * @Author: jianlong.cui
 * @Date: 2021/3/25
 * @Version: 1.0
 * @Desc volatile 正常情况下
 */
public class VolatileCanStop implements Runnable {

  private volatile boolean canceled = false;

  @Override
  public void run() {

    int num = 0;
    try {
      while (!canceled && num <= 10000) {
        if (num % 10 == 0) {
          System.out.println(num + "是10的整数倍");
        }
        num++;
        Thread.sleep(1);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws InterruptedException {

    VolatileCanStop r = new VolatileCanStop();
    Thread thread = new Thread(r);
    thread.start();
    Thread.sleep(3000);
    r.canceled = true;
  }

}
